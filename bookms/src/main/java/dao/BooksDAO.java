package dao; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 
public class BooksDAO { 
 private Connection cn; 
 private Statement st; 
 public BooksDAO() { 
  try { 
   Class.forName("com.mysql.cj.jdbc.Driver"); 
   cn = 
DriverManager.getConnection("jdbc:mysql://localhost:3306/bookms", 
"scott", "tiger"); 
   st = cn.createStatement(); 
   System.out.println("success.."); 
  } catch (Exception e) { 
   System.out.println(e); 
  } 
 } 
 
 public boolean createBook(String btitle, String pub, String 
auth,float cost,int qty) { 
  boolean flag = false; 
  try { 
   if (!isBookExisted(btitle)) { 
    String qry = String.format("insert into books values(%d,'%s','%s','%s',%f,%d)", getMaxBID() + 1, btitle, 
pub,auth,cost,qty); 
    int n = st.executeUpdate(qry); 
    if (n > 0) 
     flag = true; 
   } 
 
  } catch (Exception e) { 
   System.out.println("in create book"); 
   System.out.println(e); 
  } 
  return flag; 
 } 
 
 public boolean delBook(int bookid) { 
  boolean flag = false; 
  try { 
   String qry = String.format("delete from books where bookid=%d", bookid); 
   int n = st.executeUpdate(qry); 
   if (n > 0) 
    flag = true; 
  } catch (Exception e) { 
  } 
  return flag; 
 } 
 
 public boolean changeBook(int bookid,float price,int qty) { 
  boolean flag = false; 
  try { 
   String qry = String.format("update books set cost=%.2f, qty=%d where bookid=%d", price, qty,bookid); 
   System.out.println(qry); 
   int n = st.executeUpdate(qry); 
   if (n > 0) 
    flag = true; 
  } catch (Exception e) { 
   System.out.println(e); 
  } 
  return flag; 
 } 
 
 public int getMaxBID() { 
  int mbookid = 0; 
  try { 
   ResultSet rs = st.executeQuery("select max(bookid) from books"); 
   rs.next(); 
   mbookid = rs.getInt(1); 
   rs.close(); 
  } catch (Exception e) { 
  } 
  return mbookid; 
 } 
 public boolean isBookExisted(String btitle) { 
  int n = 0; 
  try { 
   String qry = String.format("select count(*) from books where btitle='%s'", btitle); 
   ResultSet rs = st.executeQuery(qry); 
   rs.next(); 
   n = rs.getInt(1); 
   rs.close(); 
  } catch (Exception e) { 
  } 
  return n > 0 ? true : false; 
 } 
}
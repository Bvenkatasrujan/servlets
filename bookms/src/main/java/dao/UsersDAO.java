package dao; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 
public class UsersDAO { 
private Connection cn; 
private Statement st; 
public UsersDAO() { 
 try { 
  Class.forName("com.mysql.cj.jdbc.Driver"); 
  cn = 
DriverManager.getConnection("jdbc:mysql://localhost:3306/bookms", 
"scott", "tiger"); 
  st = cn.createStatement(); 
  System.out.println("success.."); 
  } catch (Exception e) {} 
} 
 
public boolean createUser(String uname, String pwd, String role) { 
boolean flag = false; 
 try { 
   if (!isUserExisted(uname)) { 
   String qry = String.format("insert into users values(%d,'%s','%s','%s')", getMaxUID() + 1, uname, pwd, 
      role); 
   int n = st.executeUpdate(qry); 
   if (n > 0) 
    flag = true; 
   } 
  } catch (Exception e) {} 
  return flag; 
} 
public boolean delUser(int uid) { 
 boolean flag = false; 
 try { 
  String qry = String.format("delete from users where uid=%d", 
uid); 
  int n = st.executeUpdate(qry); 
  if (n > 0) 
   flag = true; 
  } catch (Exception e) {} 
  return flag; 
} 
 
public boolean changePassword(String uname, String npwd) { 
 boolean flag = false; 
 try { 
  String qry = String.format("update users set pwd='%s' where uname='%s'", npwd, uname); 
  int n = st.executeUpdate(qry); 
  if (n > 0) 
   flag = true; 
  } catch (Exception e) {} 
  return flag; 
} 
public int getMaxUID() { 
 int muid = 0; 
 try { 
  ResultSet rs = st.executeQuery("select max(uid) from users"); 
  rs.next(); 
  muid = rs.getInt(1); 
  rs.close(); 
  } catch (Exception e) {} 
  return muid; 
} 
public boolean isUserExisted(String uname) { 
 int n = 0; 
 try { 
  String qry = String.format("select count(*) from users where uname='%s'", uname); 
  ResultSet rs = st.executeQuery(qry); 
  rs.next(); 
  n = rs.getInt(1); 
  rs.close(); 
  } catch (Exception e) {} 
  return n > 0 ? true : false; 
} 
 
public boolean verifyUser(String uname, String pwd, String role) { 
 boolean flag = false; 
 try { 
  String qry = String.format("select count(*) from users where uname='%s' and pwd='%s' and role='%s'", uname, 
     pwd, role); 
  ResultSet rs = st.executeQuery(qry); 
  rs.next(); 
  if (rs.getInt(1) > 0) 
   flag = true; 
 
 } catch (Exception e) {} 
 return flag; 
  } 
}
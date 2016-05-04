/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r.mavenproject2;

import java.util.Collection;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author a.egorov
 */
@ServerEndpoint("/websocket")
public class websocket {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("r_mavenproject2_war_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    String result = "";

    @OnOpen
    public void eventOpen() {
        System.out.println("Соединение установлено...");
    }

    @OnClose
    public void eventClose() {
        System.out.println("Соединение закрыто...");
    }

    @OnMessage
    public String EventMessage(String message) {
        System.out.println("Получено сообщение от клиента:" + message);
        String temp[] = message.split("#");
        int t = Integer.parseInt(temp[0]);

        switch (t) {
            case 1: {
                result = "";
                Collection emps = em.createNativeQuery("SELECT * FROM films WHERE id_f=" + temp[1]).getResultList();
                for (Iterator i = emps.iterator(); i.hasNext();) {
                    Object[] obj = (Object[]) i.next();
                    result = "1#" + String.valueOf(obj[0]) + "#"
                            + String.valueOf(obj[1]) + "#"
                            + String.valueOf(obj[2]) + "#"
                            + String.valueOf(obj[3]) + "#"
                            + String.valueOf(obj[4]) + "#"
                            + String.valueOf(obj[5]) + "#"
                            + String.valueOf(obj[6]);
                }

                break;
            }
            case 2: {
                System.out.println("2!");
                result = "";
                int k = 0;
                Collection emps1 = em.createNativeQuery("SELECT  date, time, price, id_s FROM seans WHERE id_f=" + temp[1]).getResultList();
                for (Iterator j = emps1.iterator(); j.hasNext();) {
                    Object[] obj1 = (Object[]) j.next();
                    k++;
                    result = result + String.valueOf(obj1[0]) + "#"
                            + String.valueOf(obj1[1]) + "#"
                            + String.valueOf(obj1[2]) + "#"
                            + String.valueOf(obj1[3]) + "#";

                }
                result = "2#" + k + "#" + result;

                break;
            }
            case 3: {
                System.out.println("3!");
                result = "";
                int k = 0;
                Collection emps1 = em.createNativeQuery("SELECT  id_f, name,`like`, dislike FROM films order by `id_f` desc limit 6").getResultList();
                for (Iterator j = emps1.iterator(); j.hasNext();) {
                    Object[] obj1 = (Object[]) j.next();
                    k++;
                    result = result + String.valueOf(obj1[0]) + "#"
                            + String.valueOf(obj1[1]) + "#"
                            + String.valueOf(obj1[2]) + "#"
                            + String.valueOf(obj1[3]) + "#";

                }
                result = "3#" + k + "#" + result;

                break;
            }
            case 4: {
                System.out.println("4!");
                result = "";
                int k = 0;
                Collection emps1 = em.createNativeQuery("SELECT  id_f, name,`like`, dislike FROM films order by `like` desc limit 6").getResultList();
                for (Iterator j = emps1.iterator(); j.hasNext();) {
                    Object[] obj1 = (Object[]) j.next();
                    k++;
                    result = result + String.valueOf(obj1[0]) + "#"
                            + String.valueOf(obj1[1]) + "#"
                            + String.valueOf(obj1[2]) + "#"
                            + String.valueOf(obj1[3]) + "#";

                }
                result = "4#" + k + "#" + result;

                break;
            }
            case 5: {
                System.out.println("5!");
                result = "";
                int k = 0;
                Collection emps1 = em.createNativeQuery("SELECT  id_f, name,`like`, dislike FROM films").getResultList();
                for (Iterator j = emps1.iterator(); j.hasNext();) {
                    Object[] obj1 = (Object[]) j.next();
                    k++;
                    result = result + String.valueOf(obj1[0]) + "#"
                            + String.valueOf(obj1[1]) + "#"
                            + String.valueOf(obj1[2]) + "#"
                            + String.valueOf(obj1[3]) + "#";

                }
                result = "5#ВСЕ ФИЛЬМЫ#" + k + "#" + result;

                break;
            }
            case 6: {
                System.out.println("6!");
                result = "";
                int k = 0;
                Collection emps1 = em.createNativeQuery("SELECT  id_f, name,`like`, dislike FROM films where `" + temp[1] + "`='" + temp[2] + "'").getResultList();
                for (Iterator j = emps1.iterator(); j.hasNext();) {
                    Object[] obj1 = (Object[]) j.next();
                    k++;
                    result = result + String.valueOf(obj1[0]) + "#"
                            + String.valueOf(obj1[1]) + "#"
                            + String.valueOf(obj1[2]) + "#"
                            + String.valueOf(obj1[3]) + "#";

                }
                result = "6#" + temp[2].toUpperCase() + "#" + k + "#" + result;

                break;
            }
            case 7: {
                System.out.println("7!");
                result = "";
                int k = 0;
                //     em.getTransaction().begin();   
                //  int n= em.createNativeQuery("update films set `" + temp[2] + "`=`" + temp[2] + "`" + 1 + "where id_f=" + temp[1]).executeUpdate();
                // em.getTransaction().commit();

//             //  Query queryRenameCity = em.createQuery(
//                //        "UPDATE films f SET f.like = 5 WHERE f.id_f = 1");
//              //  int n = queryRenameCity.executeUpdate();
//           
//              
//              
////              Query aQuery = null;
////              try {            
////            aQuery = em.createNativeQuery("update films set `" + temp[2] + "`=`" + temp[2] + "`" + 1 + "where id_f=" + temp[1]);
////            // Convert to delegate when on EE container - otherwise just return same EE EM
////           
////            // If container managed TX - do not begin/end as SE
////           
////            em.getTransaction().begin();           
////            aQuery.executeUpdate();
////            em.getTransaction().commit();
//           
////        } catch (Exception e) {
////            e.printStackTrace();
////        }             
                result = "7#n";
                break;
            }
            case 8: {
                System.out.println("8!");
                result = "";
                int k = 0;
                Collection emps1 = em.createNativeQuery("SELECT seans.*, films.name FROM seans, films WHERE seans.id_s ='" + temp[1] + "' AND films.id_f=seans.id_f").getResultList();

                for (Iterator j = emps1.iterator(); j.hasNext();) {
                    Object[] obj1 = (Object[]) j.next();
                    k++;
                    result = result + String.valueOf(obj1[0]) + "#" //id_s
                            + String.valueOf(obj1[1]) + "#" //id_f
                            + String.valueOf(obj1[2]) + "#" //dateаг
                            + String.valueOf(obj1[3]) + "#" //time
                            + String.valueOf(obj1[4]) + "#" //price
                            + String.valueOf(obj1[5]) //r1
                            + String.valueOf(obj1[6]) //r2
                            + String.valueOf(obj1[7]) //r3
                            + String.valueOf(obj1[8]) //r4
                            + String.valueOf(obj1[9]) //r5
                            + String.valueOf(obj1[10]) + "#"//r6
                            + String.valueOf(obj1[11]) + "#";    //name

                }
                result = "8#" + result;

                break;
            }
            case 9: {
                System.out.println("9!");
                result = "";
                int k = 0;
                em.getTransaction().begin();
                int n = em.createNativeQuery("update seans set "
                        + "`row1`='" + temp[2] + "',"
                        + "`row2`='" + temp[3] + "',"
                        + "`row3`='" + temp[4] + "',"
                        + "`row4`='" + temp[5] + "',"
                        + "`row5`='" + temp[6] + "',"
                        + "`row6`='" + temp[7] + "'"
                        + " where id_s=" + temp[1]).executeUpdate();
                em.getTransaction().commit();
                result = "9#n";
                break;
            }
            case 10: {
                System.out.println("10!");
                result = "";
                int k = 0;
                em.getTransaction().begin();
                int n = em.createNativeQuery("INSERT INTO `films` (`name`, `genre`, `age`, `about`, `year`, `country`, `like`, `dislike`) VALUES ("
                        + "'" + temp[1] + "',"
                        + "'" + temp[2] + "',"
                        + temp[3] + ","
                        + "'" + temp[4] + "',"
                        + temp[5] + ","
                        + "'" + temp[6] + "',0,0)"
                ).executeUpdate();
                em.getTransaction().commit();
                result = "10#" + temp[1];
                break;
            }
            case 16:
            case 14:
            case 11: {
                System.out.println(temp[0] + "!");
                result = "";
                int k = 0;
                Collection emps = em.createNativeQuery("SELECT id_f,name FROM films").getResultList();
                for (Iterator i = emps.iterator(); i.hasNext();) {
                    Object[] obj = (Object[]) i.next();
                    k++;
                    result = result + String.valueOf(obj[0]) + "#"
                            + String.valueOf(obj[1]) + "#";
                }
                result = temp[0] + "#" + k + "#" + result;
                break;
            }
            case 12: {
                System.out.println("12!");
                result = "";
                Collection emps = em.createNativeQuery("SELECT * FROM films WHERE id_f=" + temp[1]).getResultList();
                for (Iterator i = emps.iterator(); i.hasNext();) {
                    Object[] obj = (Object[]) i.next();
                    result = "12#" + String.valueOf(obj[0]) + "#"
                            + String.valueOf(obj[1]) + "#"
                            + String.valueOf(obj[2]) + "#"
                            + String.valueOf(obj[3]) + "#"
                            + String.valueOf(obj[4]) + "#"
                            + String.valueOf(obj[5]) + "#"
                            + String.valueOf(obj[6]);
                }

                break;
            }
            case 13: {
                System.out.println("13!");
                result = "";
                int k = 0;
                em.getTransaction().begin();
                int n = em.createNativeQuery("update films set "
                        + "`name`='" + temp[2] + "',"
                        + "`genre`='" + temp[3] + "',"
                        + "`age`='" + temp[4] + "',"
                        + "`about`='" + temp[5] + "',"
                        + "`year`='" + temp[6] + "',"
                        + "`country`='" + temp[7] + "'"
                        + " where id_f=" + temp[1]).executeUpdate();
                em.getTransaction().commit();
                result = "13#" + temp[2];
                break;
            }
            case 15: {
                System.out.println("15!");
                result = "";
                int k = 0;
                em.getTransaction().begin();
                int n = em.createNativeQuery("delete from films where id_f=" + temp[1]).executeUpdate();
                em.getTransaction().commit();
                result = "15#" ;
                break;
            }
        }
        //String reply="Ваше сообщение: "+message+" было полученно;";
        //int idf = Integer.parseInt(message);
        //Integer id=0;String name = "";
//        Collection emps = em.createNativeQuery("SELECT * FROM films WHERE id_f=" + idf).getResultList();
//        for(Iterator i=emps.iterator(); i.hasNext();){
//             Object[] obj = (Object[]) i.next();  
//            id = Integer.parseInt(String.valueOf(obj[0])); //SERVICE assumed as int
//            name = String.valueOf(obj[1]);
//        }
        System.out.println(result);
        return result;
    }

    @OnError
    public void eventError(Throwable t) {
        System.err.println("Error WebSocket" + t);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r.mavenproject2;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kleopatra
 */
@Local
public interface SeansFacadeLocal {

    void create(Seans seans);

    void edit(Seans seans);

    void remove(Seans seans);

    Seans find(Object id);

    List<Seans> findAll();

    List<Seans> findRange(int[] range);

    int count();
    
}

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
public interface FilmsFacadeLocal {

    void create(Films films);

    void edit(Films films);

    void remove(Films films);

    Films find(Object id);

    List<Films> findAll();

    List<Films> findRange(int[] range);

    int count();
    
}

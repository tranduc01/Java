/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llpkg;

/**
 *
 * @author USER
 */
public class MySortedLLTest {
    public static void main(String[] args) {
        MySortedLL list= new MySortedLL();
        list.add(9,5,1,2,6,8,7,3,4,0);
        MyIterator it=list.iterator();
        while(it.hasNext()) System.out.print(it.next()+", ");
        System.out.println();
        
        LL_Element result=list.search(8);
        if(result!=null) System.out.println("8 existed");
        else System.out.println("8 doesn't existed");
        
        list.remove(8);
        System.out.println("After 8 was removed");
        it=list.iterator();
        while(it.hasNext()) System.out.print(it.next()+", ");
        System.out.println();
    }
}

package exercicio13;

//import org.junit.Test;
import org.junit.jupiter.api.Test;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapaDispersaoTest {

    @Test
    public void testInserir() {
        MapaDispersao<Aluno> instance = new MapaDispersao(51);
        Aluno obj1 = new Aluno("Jean", 12000);
        instance.inserir(12000,obj1);
        
        assertEquals(obj1 , instance.buscar(12000));
    }
    @Test
    public void testBuscar() {
        MapaDispersao<Aluno> instance = new MapaDispersao(51);
        Aluno obj1 = new Aluno("Jean", 12000);
        instance.inserir(12000,obj1);
        Aluno obj2 = new Aluno("Pedro", 14000);
        instance.inserir(14000,obj2);
        Aluno obj3 = new Aluno("Marta", 12500);
        instance.inserir(12500,obj3);
        Aluno obj4 = new Aluno("Lucas", 13000);
        instance.inserir(13000,obj4);
        
        
        //12000 Jean 01/01/2000
        //14000 Pedro 20/01/1999
        //12500 Marta 18/02/2001
        //13000 Lucas 
        
        assertEquals(obj1 , instance.buscar(12000));
        assertEquals(obj2 , instance.buscar(14000));
        assertEquals(obj3 , instance.buscar(12500));
        assertEquals(obj4 , instance.buscar(13000));
    }
    @Test
    public void testBuscar2() {
        MapaDispersao<Aluno> instance = new MapaDispersao(51);
        Aluno obj1 = new Aluno("Jean", 12000);
        instance.inserir(12000,obj1);
        Aluno obj2 = new Aluno("Pedro", 14000);
        instance.inserir(14000,obj2);
        Aluno obj3 = new Aluno("Marta", 12500);
        instance.inserir(14244,obj3);
        Aluno obj4 = new Aluno("Lucas", 13000);
        instance.inserir(17213,obj4);
        
        
        //12000 Jean 01/01/2000
        //14000 Pedro 20/01/1999
        //14244 Marta 18/02/2001
        //17213 Lucas 25/11/1998 
        
        assertEquals(obj1 , instance.buscar(12000));
        assertEquals(obj2 , instance.buscar(14000));
        assertEquals(obj3 , instance.buscar(14244));
        assertEquals(obj4 , instance.buscar(17213));
    }
    
}

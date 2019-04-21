import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.*;

import display.*;
import player.*;
import animals.*;
import farm_products.*;
import side_products.*;

public class TestEngisFarm {
  Display d = new Display("display/Map.txt");;
  Player p = new Player();;
  AnimalArray animals = new AnimalArray();

  @Test
  public void testPlayerWalkUp() {
    p.walk('U',d,animals);
    int X = p.getI();
    System.out.println("testPlayerWalkUp ");
    assertEquals(4, X, 0.0);
  }

  @Test
  public void testPlayerWalkDown() {
    p.walk('D',d,animals);
    int X = p.getI();
    System.out.println("testPlayerWalkDown ");
    assertEquals(6, X, 0.0);
  }

  @Test
  public void testPlayerWalkLeft() {
    p.walk('L',d,animals);
    int X = p.getJ();
    System.out.println("testPlayerWalkLeft ");
    assertEquals(4, X, 0.0);
  }

  @Test
  public void testPlayerWalkRight() {
    p.walk('R',d,animals);
    int X = p.getJ();
    System.out.println("testPlayerWalkRight ");
    assertEquals(6, X, 0.0);
  }

  @Test
  public void testKill() {
    int i = animals.getMember(5).getI();
    int j = animals.getMember(5).getJ();

    p.kill(i,j,animals);

    int jmlAnimals = animals.getLength();
    int jmlProduct = p.getBagFP().getSize();
    int total = jmlAnimals - jmlProduct;
    System.out.println("testKill ");

    assertEquals(5, jmlAnimals, 0.0);
  }

  @Test
  public void testTalk() {
    int i = animals.getMember(2).getI();
    int j = animals.getMember(2).getJ();
    String X = p.talk(i,j,animals);
    System.out.println("testTalk ");

    assertEquals("Moo-o-o!", X);
  }

  @Test
  public void testInteractWell() {
    p.setWater(10);
    int i = d.getIWell();
    int j = d.getJWell();
    boolean succ = p.interactWell(d,i,j);

    int X = p.getWater();
    System.out.println("testInteractWell ");

    assertEquals(40, X);
  }

  @Test
  public void testInteractTruck() {
    p.typeBasedAdd(1);
    int i = d.getITruck();
    int j = d.getJTruck();
    boolean succ = p.interactTruck(d,i,j);

    int X = p.getMoney();
    System.out.println("testInteractTruck ");

    assertEquals(5, X);
  }

  @Test
  public void testInteractAnimal() {
    animals.getMember(2).setProductive(true);

    int i = animals.getMember(2).getI();
    int j = animals.getMember(2).getJ();
    int X = p.interactAnimal(animals,d,i,j);
    System.out.println("testInteractAnimal ");

    assertEquals(3, X);
  }

  @Test
  public void testMix() {
    p.typeBasedAdd(1);
    p.typeBasedAdd(2);
    int i = d.getIMixer();
    int j = d.getJMixer();
    boolean succ = p.mix(d,new Omlette(),i,j);
    System.out.println("testMix ");

    int X = p.getBagSP().getSize();

    assertEquals(1, X);
  }

}

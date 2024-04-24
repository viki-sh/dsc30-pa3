import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CharQueueTest {
    CharQueue obj;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        obj = new CharQueue();
    }

    @Test
    public void charQueueDef1(){
        obj.enqueue('e');
        assertEquals(obj.size(), 1);

    }
    @Test
    public void charQueueDef2(){
        assertTrue(obj.isEmpty());

    }
    @Test
    public void charQueueDef3(){
        obj.enqueue('b');
        assertFalse(obj.isEmpty());

    }
    @Test
    public void charQueueConstructor1(){
        CharQueue obj1 = new CharQueue(1);
        assertTrue(obj1.isEmpty());

    }
    @Test
    public void charQueueConstructor2(){
        CharQueue obj2 = new CharQueue(40);
        assertTrue(obj2.isEmpty());

    }
    @Test
    public void charQueueConstructor3(){
        CharQueue obj3 = new CharQueue(23);
        obj3.enqueue('g');
        assertEquals(obj3.size(), 1);

    }
    @Test
    public void charQueueConstructor4() {
        assertThrows(IllegalArgumentException.class, () -> {
            CharQueue obj4 = new CharQueue(0);
        });
    }
    @Test
    public void isEmptyTest1(){
        obj.enqueue('a');
        assertEquals(obj.isEmpty(), false);
    }
    @Test
    public void isEmptyTest2(){
        assertEquals(obj.isEmpty(), true);

    }
    @Test
    public void isEmptyTest3(){
        obj.enqueue('g');
        obj.enqueue('f');
        obj.enqueue('e');
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        assertEquals(obj.isEmpty(), true);

    }
    @Test
    public void sizeTest1(){
        obj.enqueue('g');
        obj.enqueue('f');
        obj.enqueue('e');
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        assertEquals(obj.size(), 0);
    }
    @Test
    public void sizeTest2(){
        obj.enqueue('g');
        assertEquals(obj.size(), 1);
    }
    @Test
    public void sizeTest3(){
        assertEquals(obj.size(), 0);
    }
    @Test
    public void clearTest1(){
        obj.enqueue('g');
        obj.enqueue('f');
        obj.enqueue('e');
        obj.clear();
        assertEquals(obj.isEmpty(), true);
    }
    @Test
    public void clearTest2(){
        obj.enqueue('g');
        obj.clear();
        assertEquals(obj.size(), 0);
    }
    @Test
    public void clearTest3() {
        obj.enqueue('g');
        obj.enqueue('e');
        obj.dequeue();
        obj.clear();
        assertEquals(obj.size(), 0);
    }
    @Test
    public void enqueue1() {
        obj.enqueue('g');
        obj.enqueue('e');
        assertEquals(obj.size(), 2);
    }
    @Test
    public void enqueue2() {
        CharQueue obj1 = new CharQueue(2);
        obj1.enqueue('e');
        obj1.enqueue('r');
        obj1.enqueue('r');
        assertEquals(obj1.size(), 3);
    }
    @Test
    public void enqueue3() {
        CharQueue obj1 = new CharQueue(2);
        obj1.enqueue('e');
        obj1.enqueue('r');
        obj1.enqueue('t');
        assertEquals(obj1.size(), 3);
        assertEquals(obj1.dequeue(), 'e');

    }
    @Test
    public void peek1() {
        obj.enqueue('g');
        obj.enqueue('e');
        assertEquals(obj.peek(), 'g');
    }
    @Test
    public void peek2() {
        obj.enqueue('g');
        obj.dequeue();
        obj.enqueue('e');
        assertEquals(obj.peek(), 'e');
    }
    @Test
    public void peek3() {
        obj.enqueue('g');
        obj.dequeue();
        obj.enqueue('e');
        obj.enqueue('f');
        obj.clear();
        obj.enqueue('p');
        assertEquals(obj.peek(), 'p');
    }
    @Test
    public void peek4() {
        assertThrows(NoSuchElementException.class, () -> {
            obj.peek();
        });
    }
    @Test
    public void dequeue1() {
        obj.enqueue('g');
        assertEquals(obj.dequeue(),'g');
    }
    @Test
    public void dequeue2() {
        obj.enqueue('g');
        obj.enqueue('e');
        obj.dequeue();
        assertEquals(obj.dequeue(), 'e');
    }
    @Test
    public void dequeue3() {
        obj.enqueue('v');
        obj.enqueue('e');
        obj.dequeue();
        obj.dequeue();
        assertEquals(obj.isEmpty(), true);
    }
    @Test
    public void dequeue4() {
        assertThrows(NoSuchElementException.class, () -> {
            obj.dequeue();
        });
    }

}
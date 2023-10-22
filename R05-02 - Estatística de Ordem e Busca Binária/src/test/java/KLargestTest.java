import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.KLargestOrderStatisticsImpl;

public class KLargestTest {

    private KLargestOrderStatisticsImpl<Integer> implemetation;
    private Integer[] vetorPadrao;
    private Integer[] vetorTamPar;
    private Integer[] vetorNegativos;

    @Before
    public void setUp() {
        implemetation = new KLargestOrderStatisticsImpl<Integer>();
        populaVetorPadrao(new Integer[] { 0, 7, 3, 9, 2, 10 });
        populaVetorTamPar(new Integer[] { 0, 7, 2, -1 });
        populaVetorNegativo(new Integer[] { -6,  -10, -7, -8, -2 });
    }

    private void populaVetorPadrao(Integer[] array) {
        this.vetorPadrao = Arrays.copyOf(array, array.length);
    }

    private void populaVetorTamPar(Integer[] array) {
        this.vetorTamPar = Arrays.copyOf(array, array.length);
    }

    private void populaVetorNegativo(Integer[] array) {
        this.vetorNegativos = Arrays.copyOf(array, array.length);
    }

    @Test
    public void FloorBinarySearchTest2() {
        assertArrayEquals(this.implemetation.getKLargest(vetorPadrao, 3), new Integer[] { 7, 9, 10 });
    }

    @Test
    public void FloorBinarySearchTest3() {
        assertArrayEquals(this.implemetation.getKLargest(vetorPadrao, 2), new Integer[] { 9, 10 });
    }

    @Test
    public void FloorBinarySearchTest4() {
        assertArrayEquals(this.implemetation.getKLargest(vetorPadrao, 1), new Integer[] { 10 });
    }

    @Test
    public void FloorBinarySearchTest5() {
        assertArrayEquals(this.implemetation.getKLargest(vetorTamPar, 2), new Integer[] { 2, 7 });
    }

    @Test
    public void FloorBinarySearchTest6() {
        assertArrayEquals(this.implemetation.getKLargest(vetorPadrao, 6), new Integer[] { 0, 2, 3, 7, 9, 10 });
    }
    
    @Test
    public void FloorBinarySearchTest7() {
        assertArrayEquals(this.implemetation.getKLargest(vetorNegativos, 3), new Integer[] { -7, -6, -2 });
    }

    @Test
    public void FloorBinarySearchTest8() {
        assertArrayEquals(this.implemetation.getKLargest(vetorNegativos, 7), new Integer[] {  });
    }

    @Test
    public void FloorBinarySearchTest9() {
        assertArrayEquals(this.implemetation.getKLargest(vetorNegativos, 0), new Integer[] {  });
    }


}

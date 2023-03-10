//Muhammed Ali Gürbüzhan 02185076062
package heap;

public class Heap {
private static int n;

private int left(int i)
{
return (2 * i) + 1;
}

private int right(int i)
{
return (2 * i) + 2;
}

public int minimum(int [] array)
{
return array[array.length - 1];
}

public int maximum(int [] array)
{
return array[0];
}

public void sort(int [] array)
{
n = array.length-1;

heapify(array); // O(n) tüm diziyi düzenle
// tüm sort işlemi => O(n log(n))
}

private void heapify(int [] array)
{
for(int i = n; i >= 0; i--) heap(array,i); // her heap sorgusu => O (log(n))
}

private void heap(int [] array, int i)
{
int left = left(i); // şuanki indisin sol çocuğu
int right= right(i);// şuanki indisin sağ çocuğunun indisi
int largest = i; // kendisini büyükmüş gibi görüyoruz

if((left <= n) && (array[left] > array[largest]) ) // sol çocuğu büyükse en büyük sol oluyor
largest = left;

if((right <= n) && (array[right] > array[largest]) ) // sağ ile büyüğü karşılaştırıyoruz
largest = right; // büyükse en büyük sağ çocuk oluyor

if(largest != i) // iki indis aynı olana kadar
{
// indisler arası değiştirme, swap işlemi yapıyoruz
int temp = array[i];
array[i] = array[largest];
array[largest] = temp;

heap(array,largest); // değiştirilen indisleri kontrol etme
}
}

public void print(int [] array)
{
for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
}

public static void main(String[] args)
{
Heap h = new Heap();
int[] array = {1,67,41,66,123,71,5,3,7,9,99};
System.out.println("Dizinin Sıralanmamış hali");
h.print(array);

h.sort(array); // sırala

System.out.println("\nDizinin Heap Sıralanmış hali");
h.print(array);
System.out.println("\nMaksimum Değer : " + h.maximum(array));
System.out.println("Minimum Değer : " + h.minimum(array));
}
}
package com.javaKodCalismaKarti.ui;

import com.javaKodCalismaKarti.model.Flashcard;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;             //burada eklediğimiz importlar arayüzler listeler ve gui leri import ettik
import java.util.List;

public class KartArayuzu extends JFrame {
    private List<Flashcard> kartListesi; //kartları tutacağımız arrayimiz
    private int mevcutKartIndeksi = 0;
    private boolean onYuzuMu = true; // konu ve açıklama arkalı önlü olduğu için onun kontrolü

    private JTextArea kartIcerigi; //içerik ve butonları burada tanımlıyoruz
    private JButton cevirButon;
    private JButton sonrakiButon;
    private JButton geriButon;

    public KartArayuzu() {//kartların içeriğini burada dolduruyoruz
        kartListesi = new ArrayList<>();
        kartListesi.add(new Flashcard("implements", "Bir sınıfın interface'i uyguladığını belirtir.\n" +
                "Bir sınıf, interface'deki tüm abstract metotları tanımlamak zorundadır. Bir sınıf birden fazla interface'i uygulayabilir.\n" +
                "\n" +
                "public class Dog implements Speaker, Runnable {\n" +
                "  public void speak() { ... }\n" +
                "}"));
        kartListesi.add(new Flashcard("interface", "Abstract metot ve sabitlerden oluşan sözleşme.\n" +
                "Bir interface instantiate edilemez. İçindeki metotlar varsayılan olarak public ve abstract'tır. Sınıflar implements ile uygular. Çoklu uygulama mümkündür.\n" +
                "\n" +
                "public interface Doable {\n" +
                "  public void doThis();\n" +
                "  public int doThat();\n" +
                "}"));
        kartListesi.add(new Flashcard("abstract", "Soyut sınıf veya metot tanımlar.\n" +
                "abstract sınıf instantiate edilemez; hiyerarşide genel bir kavramı temsil eder. abstract metotun gövdesi yoktur; alt sınıflar onu override etmek zorundadır. Bir sınıf abstract metot içermeden de abstract ilan edilebilir.\n" +
                "\n" +
                "public abstract class Shape {\n" +
                "  public abstract double area(); // gövde yok\n" +
                "  public void print() { ... }   // normal metod\n" +
                "}"));
        kartListesi.add(new Flashcard("extends", "Kalıtım ilişkisi kurmak için kullanılır.\n" +
                "Bir sınıfın başka bir sınıftan türediğini belirtir. Alt sınıf (child/subclass), üst sınıfın (parent/superclass) tüm metot ve değişkenlerini miras alır. Java'da tek kalıtım (single inheritance) desteklenir.\n" +
                "\n" +
                "public class Car extends Vehicle {\n" +
                "  // Vehicle'ın tüm üyeleri miras alınır\n" +
                "}"));
        kartListesi.add(new Flashcard("super", "Üst sınıfa başvurur; yapıcı veya metod çağrısında kullanılır.\n" +
                "Alt sınıf yapıcısının ilk satırında super(...) ile üst sınıf yapıcısı çağrılmalıdır. super.metodAdı() ile üst sınıfın override edilmiş metotlarına erişilebilir.\n" +
                "\n" +
                "public Dictionary2(int pages, int defs) {\n" +
                "  super(pages); // Book2'nin constructor'ı\n" +
                "  definitions = defs;\n" +
                "}"));
        kartListesi.add(new Flashcard("this", "Nesnenin kendi kendine başvurmasını sağlar.\n" +
                "Bir metodun, üzerinde çalıştığı nesneye referans vermesini sağlar. Özellikle parametre adları ile instance değişken adları çakıştığında kullanılır.\n" +
                "\n" +
                "public Account(String name, double balance) {\n" +
                "  this.name = name;\n" +
                "  this.balance = balance;\n" +
                "}"));
        kartListesi.add(new Flashcard("static", "Üyeyi nesneye değil sınıfa bağlar.\n" +
                "static değişkenler tüm nesneler tarafından paylaşılır; sınıf ilk yüklendiğinde oluşturulur. static metotlar instance değişkenlerine erişemez. Sınıf adıyla çağrılır.\n" +
                "\n" +
                "public class Helper {\n" +
                "  public static int cube(int n) {\n" +
                "    return n * n * n;\n" +
                "  }\n" +
                "}\n" +
                "Helper.cube(4); // nesne olmadan çağrı"));
        kartListesi.add(new Flashcard("final", "Değiştirilemeyen değişken, metod veya sınıf tanımlar.\n" +
                "final değişken bir kez atandıktan sonra değiştirilemez. final metod override edilemez. final sınıftan alt sınıf türetilemez. abstract sınıf final olamaz.\n" +
                "\n" +
                "final int MAX = 100;         // değer değiştirilemez\n" +
                "public final void reset() {} // override edilemez\n" +
                "public final class String {} // türetilemez"));
        kartListesi.add(new Flashcard("protected", "Alt sınıf ve aynı paketten erişime izin verir.\n" +
                "private ile public arasında bir görünürlük sunar. Alt sınıfların üst sınıf üyelerine erişmesini sağlar, kapsüllemeyi tamamen bozmaz. UML diyagramlarında # simgesiyle gösterilir.\n" +
                "\n" +
                "public class FoodItem {\n" +
                "  protected int servings; // alt sınıftan erişilebilir\n" +
                "  private int fatGrams;   // alt sınıftan erişilemez\n" +
                "}"));
        kartListesi.add(new Flashcard("new", "Bellekte yeni nesne oluşturur.\n" +
                "Bir sınıfın constructor'ını çağırarak heap belleğinde yeni bir nesne oluşturur ve ona referans döndürür.\n" +
                "\n" +
                "Dictionary webster = new Dictionary();\n" +
                "Address home = new Address(\"Ana Cd.\", \"Ankara\", \"TR\", 6000);"));
        kartListesi.add(new Flashcard("void", "Metodun geri dönüş değeri olmadığını belirtir.\n" +
                "Bir metodun herhangi bir değer döndürmeyeceğini belirtmek için kullanılır. Sadece metod imzasında kullanılabilir.\n" +
                "\n" +
                "public void setPages(int numPages) {\n" +
                "  pages = numPages; // return yok\n" +
                "}"));
        kartListesi.add(new Flashcard("return", "Metoddan değer döndürür veya çıkışı sağlar.\n" +
                "void olmayan metotlarda belirtilen tipte değer döndürür. void metotlarda sadece return; yazılarak erken çıkış sağlanabilir.\n" +
                "\n" +
                "public int getCount() {\n" +
                "  return count;\n" +
                "}"));
        kartListesi.add(new Flashcard("Object", "Java'daki tüm sınıfların kökü.\n" +
                "java.lang paketinde tanımlıdır. Açıkça belirtilmese de tüm sınıflar Object'ten türer. toString(), equals(), clone() gibi temel metotları içerir. Bu metotlar alt sınıflarda override edilebilir.\n" +
                "\n" +
                "// Her sınıf Object'in alt sınıfıdır\n" +
                "MyClass obj = new MyClass();\n" +
                "obj.toString(); // Object'ten miras\n" +
                "obj.equals(other);"));
        kartListesi.add(new Flashcard("String", "Karakter dizilerini temsil eder; Comparable'ı uygular.\n" +
                "Java'da String nesneleri immutable'dır (değiştirilemez). Comparable interface'ini uygular; equals() lexicographic karşılaştırma yapar. compareTo() lexicographic sıra döndürür.\n" +
                "\n" +
                "String str1 = \"Merhaba\";\n" +
                "String str3 = str1.concat(str2);\n" +
                "str1.equals(str2); // içerik karşılaştırma\n" +
                "str1.compareTo(str2); // sıra karşılaştırma"));
        kartListesi.add(new Flashcard("Math", "Matematiksel işlemler için static metotlar sunar.\n" +
                "Tüm metotları static'tir, nesne oluşturmaya gerek yoktur. sqrt, pow, abs, min, max gibi yaygın matematiksel fonksiyonları içerir.\n" +
                "\n" +
                "double result = Math.sqrt(25); // 5.0\n" +
                "int max = Math.max(10, 20);    // 20"));
        kartListesi.add(new Flashcard("Scanner", "Kullanıcıdan veya dosyadan giriş okur.\n" +
                "java.util paketinde yer alır. nextLine(), nextInt(), nextDouble() gibi metotlarla farklı tipte giriş okunabilir.\n" +
                "\n" +
                "Scanner scan = new Scanner(System.in);\n" +
                "String input = scan.nextLine();\n" +
                "int num = scan.nextInt();"));
        kartListesi.add(new Flashcard("Comparable", "Nesneler arası sıralama için interface.\n" +
                "compareTo(Object other) metodunu tanımlar. Dönüş değeri: negatif (küçük), 0 (eşit), pozitif (büyük). String ve sayısal tipler bu interface'i uygular. Polymorphic sıralama için kullanılır.\n" +
                "\n" +
                "public class Contact implements Comparable {\n" +
                "  public int compareTo(Object other) {\n" +
                "    return lastName.compareTo(\n" +
                "      ((Contact)other).getLastName());\n" +
                "  }\n" +
                "}"));
        kartListesi.add(new Flashcard("Iterable", "for-each döngüsü için iterator sağlar.\n" +
                "iterator() metodunu tanımlar; Iterator nesnesi döndürür. Bu interface'i uygulayan nesneler for-each döngüsünde kullanılabilir. Iterator nesnesi bir iterasyon yaparken; Iterable nesne talep üzerine iterator sağlar.\n" +
                "\n" +
                "for (Contact c : contactList) {\n" +
                "  System.out.println(c);\n" +
                "}"));
        kartListesi.add(new Flashcard("toString()", "Nesneyi string olarak temsil eder.\n" +
                "Object sınıfında tanımlıdır; tüm sınıflar tarafından miras alınır. Override edilmezse sınıf adı + hash kodu döndürür. println() çağrıldığında otomatik olarak bu metod çağrılır.\n" +
                "\n" +
                "public String toString() {\n" +
                "  return firstName + \" \" + lastName;\n" +
                "}"));
        kartListesi.add(new Flashcard("equals()", "İki nesnenin eşitliğini karşılaştırır.\n" +
                "Object sınıfında varsayılan olarak referans eşitliği (== gibi) kontrol eder. Override edilerek içerik bazlı karşılaştırma yapılabilir. String sınıfı bunu içerik karşılaştırması için override etmiştir.\n" +
                "\n" +
                "public boolean equals(Object other) {\n" +
                "  return lastName.equals(\n" +
                "    ((Contact)other).getLastName());\n" +
                "}"));
        kartListesi.add(new Flashcard("clone()", "Nesnenin bir kopyasını oluşturur.\n" +
                "Object sınıfında tanımlıdır. x.clone() != x (farklı referans) fakat x.clone().equals(x) (içerik aynı) olmalıdır. Gerçek davranış sınıf tanımına bağlıdır.\n" +
                "\n" +
                "// x != x.clone() — farklı nesne\n" +
                "// x.clone().getClass() == x.getClass()\n" +
                "// x.clone().equals(x) — aynı içerik"));
        kartListesi.add(new Flashcard("pay()", "StaffMember hiyerarşisinde polimorfik ödeme metodu.\n" +
                "StaffMember'da abstract tanımlanmış; Volunteer, Employee, Executive, Hourly sınıflarında farklı şekillerde override edilmiştir. Polimorfizmin pratik örneğidir.\n" +
                "\n" +
                "amount = staffList[count].pay(); // polimorfik çağrı\n" +
                "// Nesne tipine göre farklı sürüm çalışır"));
        kartListesi.add(new Flashcard("selectionSort()", "Seçimli sıralama algoritması; Comparable dizisi alır.\n" +
                "En küçük elemanı bulup başa taşıma prensibine dayanır. Karmaşıklık O(n²). Comparable parametresi sayesinde herhangi bir nesne dizisi sıralanabilir.\n" +
                "\n" +
                "public static void selectionSort(Comparable[] list) {\n" +
                "  // her iterasyonda en küçüğü öne taşı\n" +
                "}"));
        kartListesi.add(new Flashcard("insertionSort()", "Eklemeli sıralama algoritması.\n" +
                "Her elemanı sıralı alt listenin doğru konumuna ekler. Karmaşıklık O(n²). Küçük veya neredeyse sıralı diziler için verimlidir.\n" +
                "\n" +
                "public static void insertionSort(Comparable[] list) {\n" +
                "  // elemanı yerinde sola kaydır\n" +
                "}"));
        kartListesi.add(new Flashcard("linearSearch()","Listede baştan sona arama yapar.\n" +
                "Her elemanı sırayla karşılaştırır. Karmaşıklık O(n). Sırasız listeler için çalışır. Bulamazsa null döner.\n" +
                "\n" +
                "Comparable found = Searching.linearSearch(\n" +
                "  friends, target);"));
        kartListesi.add(new Flashcard("binarySearch()", "Sıralı listede orta noktayı kesen arama yapar.\n" +
                "Her adımda arama alanını yarıya indirir. Karmaşıklık O(log n). Listenin önceden sıralı olması zorunludur.\n" +
                "\n" +
                "Sorting.selectionSort(friends);\n" +
                "Comparable found = Searching.binarySearch(\n" +
                "  friends, target);"));
        kartListesi.add(new Flashcard("traverse()", "Labirentte recursive geçiş yapar.\n" +
                "Maze sınıfında recursive olarak tanımlanmıştır. Her hücreden 4 yönde (aşağı, sağ, yukarı, sol) recursive arama yapar. Base case: geçersiz hücre veya hedefe ulaşmak.\n" +
                "\n" +
                "public boolean traverse(int row, int col) {\n" +
                "  if (valid(row, col)) {\n" +
                "    done = traverse(row+1, col); // aşağı\n" +
                "    if (!done) done = traverse(row, col+1);\n" +
                "  }\n" +
                "}"));
        kartListesi.add(new Flashcard("moveTower()", "Hanoi kulelerini recursive olarak çözer.\n" +
                "n-1 diski geçici kazığa taşı, tek diski hedef kazığa taşı, n-1 diski hedef kazığa taşı. Karmaşıklık O(2ⁿ).\n" +
                "\n" +
                "moveTower(numDisks-1, start, temp, end);\n" +
                "moveOneDisk(start, end);\n" +
                "moveTower(numDisks-1, temp, end, start);"));
        kartListesi.add(new Flashcard("Polimorfizm", "Bir referansın farklı nesne tiplerine işaret edebilmesi.\n" +
                "Java'da metot bağlama (binding) derleme zamanında değil çalışma zamanında gerçekleşir (dynamic/late binding). Referansın tipi değil, nesnenin gerçek tipi hangi metodun çalışacağını belirler. Kalıtım ve interface aracılığıyla sağlanır.\n" +
                "\n" +
                "Holiday day = new Christmas();\n" +
                "day.celebrate(); // Christmas'ın versiyonu çalışır"));
        kartListesi.add(new Flashcard("Kalıtım (Inheritance)", "Mevcut sınıftan yeni sınıf türetme.\n" +
                "Yazılım yeniden kullanımını sağlar. is-a ilişkisi kurulur. Java tek kalıtımı destekler (bir ebeveyn). Her türetme is-a ilişkisi kurmalıdır; has-a için aggregation kullanılmalıdır.\n" +
                "\n" +
                "// is-a: MountainBike is-a Bicycle\n" +
                "public class MountainBike extends Bicycle {\n" +
                "  public int seatHeight;\n" +
                "}"));
        kartListesi.add(new Flashcard("Aggregtion", "Bir nesnenin başka nesneleri içermesi (has-a).\n" +
                "has-a ilişkisini modeller. Bir nesne diğerini instance değişkeni olarak tutar. Özel bir bağımlılık türüdür. Örn: Student has-a Address.\n" +
                "\n" +
                "public class Student {\n" +
                "  private Address homeAddress;   // has-a\n" +
                "  private Address schoolAddress; // has-a\n" +
                "}"));
        kartListesi.add(new Flashcard("Method Overriding", "Alt sınıfın üst sınıf metodunu yeniden tanımlaması.\n" +
                "Aynı imza, farklı gövde. Nesnenin gerçek tipi hangi versiyonun çağrılacağını belirler. super.metodAdı() ile üst sınıfın versiyonu çağrılabilir. final metotlar override edilemez.\n" +
                "\n" +
                "public class Advice extends Thought {\n" +
                "  public void message() {\n" +
                "    System.out.println(\"Warning...\");\n" +
                "    super.message(); // üst sınıf da çağrılıyor\n" +
                "  }\n" +
                "}"));
        kartListesi.add(new Flashcard("Method Overloading", "Aynı isimde farklı imzalı birden fazla metod.\n" +
                "Aynı sınıf içinde, aynı isimde farklı parametre sayısı veya tipiyle tanımlanır. Dönüş tipi imzanın parçası değildir. Derleyici parametre tipine göre hangi versiyonun çağrılacağını belirler.\n" +
                "\n" +
                "float tryMe(int x) { return x + .375; }\n" +
                "float tryMe(int x, float y) { return x*y; }"));
        kartListesi.add(new Flashcard("Recursion", "Bir metodun kendisini çağırması.\n" +
                "Her recursive tanımın base case (taban durumu) olması zorunludur; yoksa sonsuz döngüye girer. Direct (doğrudan) ve indirect (dolaylı) olmak üzere ikiye ayrılır. Her metod çağrısı kendi yerel değişken ortamını oluşturur.\n" +
                "\n" +
                "public int factorial(int n) {\n" +
                "  if (n == 1) return 1;       // base case\n" +
                "  return n * factorial(n-1);  // recursive case\n" +
                "}"));
        kartListesi.add(new Flashcard("Late Binding", "Metod bağlamanın çalışma zamanında gerçekleşmesi.\n" +
                "Dynamic binding olarak da bilinir. Java'da tüm metot çağrıları varsayılan olarak late binding ile çalışır. Bu sayede polimorfizm mümkün olur; derleme zamanında hangi metodun çağrılacağı bilinemez.\n" +
                "\n" +
                "obj.doIt(); // hangi doIt()? Derleme zamanında bilinmez\n" +
                "// Çalışma zamanında obj'nin gerçek tipi belirlenir"));
        kartListesi.add(new Flashcard("Method Decomposition", "Büyük metodun küçük parçalara bölünmesi.\n" +
                "Her metod tek bir görevi yerine getirmeli ve küçük tutulmalıdır. Public metot, private destek metotlarını çağırabilir. Okunabilirliği ve bakımı kolaylaştırır.\n" +
                "\n" +
                "public void processData() {\n" +
                "  validateInput();   // private destek\n" +
                "  calculateResult(); // private destek\n" +
                "  displayOutput();   // private destek\n" +
                "}"));
        kartListesi.add(new Flashcard("pass by value", "Java'da parametreler değer kopyası olarak aktarılır.\n" +
                "Primitive tiplerinde değerin kopyası gönderilir; metod içi değişiklik dışarıyı etkilemez. Nesnelerde referansın kopyası gönderilir; nesnenin iç durumu değiştirilebilir ama referansın kendisi değiştirilemez.\n" +
                "\n" +
                "void changeValues(int f1, Num f2, Num f3) {\n" +
                "  f1 = 999;         // dışarıdaki a1 değişmez\n" +
                "  f2.setValue(888); // dışarıdaki a2 değişir (iç durum)\n" +
                "  f3 = new Num(777);// dışarıdaki a3 değişmez (referans)\n" +
                "}"));
        kartListesi.add(new Flashcard("instanceof", "Bir nesnenin belirli bir tipte olup olmadığını kontrol eder.\n" +
                "Çalışma zamanında tip kontrolü yapar. Cast işlemi öncesinde kullanılması önerilir. Polimorfik koda sahip koşullu işlemlerde kullanılır.\n" +
                "\n" +
                "if (staffList[i] instanceof Executive) {\n" +
                "  ((Executive)staffList[i]).awardBonus(500);\n" +
                "}"));
        kartListesi.add(new Flashcard("UML (Class Diagram)", "Sınıf ilişkilerini görsel olarak gösteren diyagram.\n" +
                "Sınıf adı, değişkenler (- private, # protected, + public), metotlar gösterilir. Kalıtım: içi boş ok. Aggregation: elmas. Bağımlılık: kesikli ok.\n" +
                "\n" +
                "Student\n" +
                "- firstName : String\n" +
                "- homeAddress : Address\n" +
                "+ toString() : String"));

        // Tasarım için renk belirliyoruz
        Color arkaPlan = new Color(10, 15, 20);
        Color neonMor = new Color(15, 25, 35);
        Color neonMavi = new Color(200, 220, 240);
        Color kartRengi = new Color(15, 25, 35);

        // uygulama kullanacağımız butonları tanımladık
        kartIcerigi = new JTextArea(yaziyiOrtala(kartListesi.get(mevcutKartIndeksi).getKonu()));
        cevirButon = new JButton("Cevir"); // Eksik olan satır buydu!
        sonrakiButon = new JButton("Siradaki");
        JPanel butonPaneli = new JPanel();

        // Renk ve Görünüm ayarlamalarını yaptık
        getContentPane().setBackground(arkaPlan);
        butonPaneli.setBackground(arkaPlan);

        // JTextArea Tasarımı
        kartIcerigi.setEditable(false);
        kartIcerigi.setLineWrap(true);
        kartIcerigi.setWrapStyleWord(true);
        kartIcerigi.setMargin(new Insets(120, 100, 100, 100));//yazıların konumlarını ayarlama kısımlar
        kartIcerigi.setBackground(kartRengi);//arkaplan rengini ayarlama
        kartIcerigi.setForeground(neonMavi);//ön kısımda rengi ayarlama
        kartIcerigi.setFont(new Font("Consolas", Font.BOLD, 22));//yazının fontu /yazı biçimi ve büyüklüğü gibi görsel ayarlamalar
        kartIcerigi.setBorder(BorderFactory.createLineBorder(neonMor, 3));

        kartIcerigi.setAlignmentX(Component.CENTER_ALIGNMENT);
        kartIcerigi.setAlignmentY(Component.CENTER_ALIGNMENT);
        // Buton Tasarımları cevir butonu için ayarlamalar
        cevirButon.setBackground(neonMor);
        cevirButon.setForeground(Color.WHITE);
        cevirButon.setFocusPainted(false);
        cevirButon.setFont(new Font("Arial", Font.BOLD, 14));
        // sonraki kısma geçen sonraki butonu için görsel ayarlamalar
        sonrakiButon.setBackground(neonMavi);
        sonrakiButon.setForeground(Color.BLACK);
        sonrakiButon.setFocusPainted(false);
        sonrakiButon.setFont(new Font("Arial", Font.BOLD, 14));

        // Uygulamayı çalıştırdığımızda gördüğümüz pencernin ayarları
        setTitle("Yagmur'un Kod Calisma Kartlari");//başlık yazısı
        setSize(500, 450); // butonların sığması için gereken kısımlar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // geri butonunun oluşturulması ve görsel tasarımı
        geriButon = new JButton("Geri"); // buton üzerinde yazan yazı
        geriButon.setBackground(new Color(0, 80, 130)); //rengi
        geriButon.setForeground(Color.WHITE);
        geriButon.setFont(new Font("Arial", Font.BOLD, 14));//yazı fontu ve boyutu
        geriButon.setFocusPainted(false);

         // GERİ BUTONU İŞLEVİ
        geriButon.addActionListener(e -> {
            // Listede bir geri git, eğer baştaysan en sona dön mantıksal ayarlamalar
            mevcutKartIndeksi = (mevcutKartIndeksi - 1 + kartListesi.size()) % kartListesi.size();
            kartIcerigi.setText(yaziyiOrtala(kartListesi.get(mevcutKartIndeksi).getKonu()));
            onYuzuMu = true;
        });
        // Kontrol kısmı ve içerik
        cevirButon.addActionListener(e -> {
            if (onYuzuMu) {
                kartIcerigi.setText("\n"+kartListesi.get(mevcutKartIndeksi).getAciklama());
            } else {
                kartIcerigi.setText(yaziyiOrtala(kartListesi.get(mevcutKartIndeksi).getKonu()));
            }
            onYuzuMu = !onYuzuMu;
        });

        sonrakiButon.addActionListener(e -> {
            mevcutKartIndeksi = (mevcutKartIndeksi + 1) % kartListesi.size();
            kartIcerigi.setText(yaziyiOrtala(kartListesi.get(mevcutKartIndeksi).getKonu()));
            onYuzuMu = true;
        });

        // Yazdığımız klass ve komutları ekrana yazdırma işlemleri
        JScrollPane scrollPane = new JScrollPane(kartIcerigi);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
        butonPaneli.add(geriButon);
        butonPaneli.add(cevirButon);
        butonPaneli.add(sonrakiButon);
        add(butonPaneli, BorderLayout.SOUTH);

        setVisible(true);
    }

    private String yaziyiOrtala(String metin) //yazının ortalanması ve ayarlanması
    {
        String dikeyBosluk = "\n".repeat(7);
        int sabitBosluk = 5;
        int dinamikBosluk = Math.max(0, (30 - metin.length()) / 2);
        String yatayBosluk = " ".repeat(sabitBosluk + dinamikBosluk);
        return dikeyBosluk + yatayBosluk + metin;
    }
}
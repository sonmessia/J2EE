import java.util.*;

public class Book {
  private int id;
  private String title;
  private String author;
  private long price;

  public Book() {
    this.id = 0;
    this.title = "Untitled";
    this.author = "Unknown";
    this.price = 0;
  }

  // Constructor
  public Book(int id, String title, String author, long price) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.price = price;
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public void input() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter book ID: ");
    this.id = scanner.nextInt();
    System.out.print("Enter book title: ");
    this.title = scanner.next();
    System.out.print("Enter book author: ");
    this.author = scanner.next();
    System.out.print("Enter book price: ");
    this.price = scanner.nextLong();
  }

  public void output() {
    String msg = """
        Book ID: %d, title: %s, author: %s, price: %d
        """.formatted(this.id, this.title, this.author, this.price);
    System.out.println(msg);
  }

}

public void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
  List<Book> books = new ArrayList<>();

  Set<Book> authorBooks = new HashSet<>();
  String msg = """
      \n
            Chương trình quản lý sách:
            1. Thêm 1 cuốn sách
            2. Xóa 1 cuốn sách
            3. Thay đổi sách
            4. Xuất thông tin
            5. Tìm sách lập trình
            6. Lấy sách tối đa theo giá
            7. Tìm kiếm theo tác giả
            0. Thoát
            Chọn chức năng
        """;
  int choice = 0;
  do {
    System.out.println(msg);
    choice = scanner.nextInt();
    switch (choice) {
      case 1 -> {
        Book book = new Book();
        book.input();
        books.add(book);
        authorBooks.add(book);
      }
      case 2 -> {
        System.out.print("Nhập ID sách cần xóa: ");
        int idToDelete = scanner.nextInt();
        books.removeIf(book -> book.getId() == idToDelete);
        System.out.println("Đã xóa sách có ID: " + idToDelete);
      }
      case 3 -> {
        System.out.print("Nhập ID sách cần thay đổi: ");
        int idToUpdate = scanner.nextInt();
        for (Book book : books) {
          if (book.getId() == idToUpdate) {
            book.input();
            System.out.println("Đã cập nhật sách có ID: " + idToUpdate);
            break;
          }
        }
      }
      case 4 -> {
        System.out.println("Danh sách sách:");
        books.forEach(Book::output);
      }
      case 5 -> {
        System.out.println("Sách lập trình:");
        books.stream()
            .filter(book -> book.getTitle().toLowerCase().contains("lập trình"))
            .forEach(Book::output);
      }
      case 6 -> {
        Book maxPriceBook = books.stream()
            .max((b1, b2) -> Long.compare(b1.getPrice(), b2.getPrice()))
            .orElse(null);
        if (maxPriceBook != null) {
          System.out.println("Sách có giá cao nhất:");
          maxPriceBook.output();
        } else {
          System.out.println("Không có sách trong danh sách.");
        }
      }
      case 7 -> {
        System.out.print("Nhập tên tác giả cần tìm: ");
        String authorToFind = scanner.next();
        System.out.println("Sách của tác giả " + authorToFind + ":");
        authorBooks.stream()
            .filter(book -> book.getAuthor().equalsIgnoreCase(authorToFind))
            .forEach(Book::output);
      }
    }
  } while (choice != 0);
  scanner.close();
}

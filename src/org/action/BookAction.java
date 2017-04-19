package org.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.dao.BookDao;
import org.dao.LendDao;
import org.model.Book;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/18.
 */
public class BookAction extends ActionSupport {
private String message;
private File photo;
private Book book;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPhoto(File photo) {
        this.photo = photo;

    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getMessage() {
        return message;
    }

    public File getPhoto() {
        return photo;
    }

    public Book getBook() {
        return book;

    }
    BookDao bookDao = new BookDao();

    /**
     *
     * 添加书籍
     * @return
     * @throws Exception
     */
    public String addBook() throws Exception {
        System.out.println("ssss");
        Book bo=bookDao.selectBook(book.getISBN());
        if(bo!=null)
        {
            this.setMessage("ISBN已经存在!");
            return SUCCESS;
        }
        Book b =new Book();
        b.setISBN(book.getISBN());
        b.setBookName(book.getBookName());
        b.setAuthor(book.getAuthor());
        b.setPublisher(book.getPublisher());
        b.setPrice(book.getPrice());
        b.setCnum(book.getCnum());
        b.setSnum(book.getSnum());
        b.setSummary(book.getSummary());
        if(this.getPhoto()!=null)
        {
            FileInputStream fis=new FileInputStream(this.getPhoto());
            byte[]buffer = new byte[fis.available()];
            fis.read(buffer);
            b.setPhoto(buffer);
            fis.close();
        }
        bookDao.addBook(b);
        System.out.println("添加成功");
        this.setMessage("添加成功!");
        return SUCCESS;
    }

    /**
     * 删除书籍
     * @return
     */
    public String deleteBook()
    {
        if(new LendDao().selectByBookISBN(book.getISBN())!=null)
        {
            this.setMessage("该图书已被借出，不能删除！");
            return SUCCESS;
        }
        Book bo =bookDao.selectBook(book.getISBN());
        if(bo==null)
        {
            this.setMessage("要删除的图书不存在!");
            return  SUCCESS;
        }
        else if(new LendDao().selectByBookISBN(book.getISBN())!=null)
        {
            this.setMessage("该图书已经被借出，不能删除!");
            return SUCCESS;
        }
        bookDao.deleteBook(book.getISBN());
        this.setMessage("删除成功!");
        return SUCCESS;
    }

    /**
     * 查询书籍
     * @return
     */
    public String selectBook()
    {
     Book oneBook = bookDao.selectBook(book.getISBN());
     if(oneBook==null)
     {
         this.setMessage("不存在该图书!");;
         return SUCCESS;
     }
        Map request = (Map) ActionContext.getContext().get("request");
     request.put("onebook",oneBook);
     return SUCCESS;
    }
    public String getImage() throws IOException {
        HttpServletResponse response= ServletActionContext.getResponse();
        String ISBN = book.getISBN();
        Book b=bookDao.selectBook(ISBN);
        byte[]photo = b.getPhoto();
        response.setContentType("image/jpeg");
        ServletOutputStream os = response.getOutputStream();
        if(photo!=null&&photo.length!=0)
        {

            for(int i=0;i<photo.length;i++)
            {
                os.write(photo[i]);
            }
            os.flush();
            os.close();
        }
        return NONE;
    }
public String updateBook() throws IOException {
    Book bo=bookDao.selectBook(book.getISBN());
    if(bo==null)
    {
        this.setMessage("要修改的图书不存在!");
        return SUCCESS;
    }
    Book b =new Book();
    b.setISBN(book.getISBN());
    b.setBookName(book.getBookName());
    b.setAuthor(book.getAuthor());
    b.setPublisher(book.getPublisher());
    b.setPrice(book.getPrice());
    b.setCnum(book.getCnum());
    b.setSnum(book.getSnum());
    b.setSummary(book.getSummary());
    if(this.getPhoto()!=null)
    {
        FileInputStream fis=new FileInputStream(this.getPhoto());
        byte[]buffer = new byte[fis.available()];
        fis.read(buffer);
        b.setPhoto(buffer);
        fis.close();
    }
    this.setMessage("修改成功!");
    return SUCCESS;
}
}

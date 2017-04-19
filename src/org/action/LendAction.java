package org.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.dao.BookDao;
import org.dao.LendDao;
import org.dao.StudentDao;
import org.model.Book;
import org.model.Lend;
import org.model.Student;
import org.org.tool.Pager;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 18673 on 2017/4/18 0018.
 */
public class LendAction extends ActionSupport {
    private int pageNow = 1;
    private int pageSize = 4;
    private Lend lend;
    private String message;

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Lend getLend() {
        return lend;
    }

    public void setLend(Lend lend) {
        this.lend = lend;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    LendDao lendDao = new LendDao();


    public String selectAllLend() throws Exception {
        if(lend.getReaderId() == null || lend.getReaderId().equals("")) {
            this.setMessage("请输入借书证号!");
            return SUCCESS;
        } else if(new StudentDao().selectByReaderId(lend.getReaderId()) == null) {
            this.setMessage("不存在该学生!");
            return SUCCESS;
        }
        System.out.println("This is The selectAllLend function !");
        List list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
        Pager page = new Pager(pageNow, lendDao.selectLendSize(lend.getReaderId()));
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("list", list);
        request.put("page", page);
        System.out.println("This is before selectAllLend function : lend.getReaderId() : " + lend.getReaderId());
        request.put("readerId", lend.getReaderId());
        return SUCCESS;
    }

    public String lendBook() throws Exception {
        BookDao bookDao = new BookDao();
        if(lend.getISBN() == null || lend.getISBN().equals("")||bookDao.selectBook(lend.getISBN())==null ||
                (bookDao.selectBook(lend.getISBN()).getSnum())<1) {
            List list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
            Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
            Map request = (Map) ActionContext.getContext().get("request");
            request.put("list",list);
            request.put("page", page);
            request.put("readerId",lend.getReaderId());
            setMessage("ISBN 不能为空 或者 不存在该ISBN图书 或该图书没有库存!");
            return SUCCESS;
        } else if(lend.getBookId() == null || lend.getBookId().equals("") || lendDao.selectByBookId(lend.getBookId()) != null) {
            List list = lendDao.selectLend(lend.getReaderId(), this.getPageNow(), this.getPageSize());
            Pager page = new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
            Map request = (Map) ActionContext.getContext().get("request");
            request.put("list",list);
            request.put("page", page);
            request.put("readerId",lend.getReaderId());
            setMessage("该图书ID 已存在 或 图书ID 为空!");
            return SUCCESS;
        }
        Lend l = new Lend();
        l.setBookId(lend.getBookId());
        l.setISBN(lend.getISBN());
        l.setReaderId(lend.getReaderId());
        l.setLendTime(new Timestamp(System.currentTimeMillis()).toString());
        lendDao.addLend(l);
        Book book = bookDao.selectBook(lend.getISBN());
        book.setSnum(book.getSnum()-1);
        bookDao.updateBook(book);
        StudentDao studentDao = new StudentDao();
        System.out.println("This is before selectByReaderId function : lend.getReaderId() : " + lend.getReaderId());
        Student student = studentDao.selectByReaderId(lend.getReaderId());
        student.setNum(student.getNum()+1);
        studentDao.updateStudent(student);
        List list = lendDao.selectLend(lend.getReaderId(),this.getPageNow(), this.getPageSize());
        Pager page = new Pager(pageNow, lendDao.selectLendSize(lend.getReaderId()));
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("list",list);
        request.put("page", page);
        request.put("readerId",lend.getReaderId());
        return  SUCCESS;
    }
}

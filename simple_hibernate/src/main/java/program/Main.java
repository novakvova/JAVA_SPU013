package program;

import emums.QuestionType;
import models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.transaction.internal.TransactionImpl;
import org.hibernate.query.Query;
import utils.HiberContext;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //testRole();
        //addQuestionItem();
        //AddUserAndRoles();
        //addCategory("Ноутбуки","1.jpg");
        //addProduct();
        try(Session context = HiberContext.getSessionFactory().openSession()) {

        }
    }
    private static void addProduct() {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            Transaction tx = context.beginTransaction();
            var cat = context.get(Category.class, 1);
            Product p =
                    new Product(new Date(), false, "Молоток", "Для цвяхів",cat);
            context.save(p);
            ProductImage pi1 = new ProductImage(new Date(), false, "1.jpg", 1, p);
            ProductImage pi2  = new ProductImage(new Date(), false, "2.jpg", 2, p);
            context.save(pi1);
            context.save(pi2);
            tx.commit();
        }
    }
    private static void addCategory(String name, String image) {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            Category c = new Category(name,image,new Date(), false);
            context.save(c);
        }
    }
    private static void AddUserAndRoles()
    {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            Transaction tx = context.beginTransaction();
            Role role = new Role();
            role.setName("Мурчик");
            context.save(role);
            User user = new User("Іван","Бомбардир","ivan@gmail.com",
                    "+38096 87 63 786","23456");
            context.save(user);
            UserRole ur = new UserRole();
            ur.setRole(role);
            ur.setUser(user);
            context.save(ur);
            tx.commit();
        }
    }
    private static void addQuestionItem(){
        try {
            //addQuestion("Коли вибухнув Чорнобиль?", QuestionType.RUDIO_BUTTON);
//            AddQuestionItem(1,"1945", false);
//            AddQuestionItem(1,"1986", true);
//            AddQuestionItem(1,"1991", false);

        } catch (Exception ex) {
            System.out.println("Виникла помилка " + ex.getMessage());
        }
    }

    private static void addQuestion(String text, QuestionType type) throws SQLException {
        Session context = HiberContext.getSessionFactory().openSession();
        Transaction tx = context.beginTransaction();
        Question q = new Question();
        q.setText(text);
        q.setQuestionType(type);
        context.save(q);
        tx.commit();
        context.close();
    }

    private static void AddQuestionItem(int questionId, String text,
                                        boolean isTrue ) throws SQLException {
        Session session = HiberContext.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Question question = new Question();
        question.setId(questionId);
        QuestionItem qi = new QuestionItem(question, text, isTrue);
        session.save(qi);
        tx.commit();
        session.close();
    }

    private static void testRole()
    {
        Scanner in = new Scanner(System.in);
//        System.out.println("Вкажіть назву ролі");
//        Role role = new Role();
//        String name = in.nextLine();
//        role.setName(name);
        Session context = HiberContext.getSessionFactory().openSession();
//        context.save(role);
//        System.out.println("Role id = "+ role.getId());
        Query query = context.createQuery("FROM Role");
        List<Role> roles = query.list();
        for (Role role : roles)
            System.out.println(role);
        context.close();
    }
}

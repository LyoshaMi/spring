package aop;

import org.springframework.stereotype.Component;

@Component("schoolLibraryBean")
public class SchoolLibrary extends AbstractLibrary{

    public void getBook() {
        System.out.println("Мы берём книгу из SchoolLibrary");
    }
}

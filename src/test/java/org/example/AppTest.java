package org.example;

import domain.Nota;
import domain.Student;
import domain.Tema;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    private Service service;


    public AppTest( String testName )
    {
        super( testName );
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        this.service = new Service(fileRepository1, fileRepository2, fileRepository3);

    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testCase1() {
        String id = "S1";
        String name = "casc Doe";
        int group = 324;

        int result = validateStudent(id, name, group);
        assertEquals(result, 1); // Success (1) expected
    }

    public void testCase2() {
        String id = "S2";
        String name = "Jane Smith";
        int group = 102;

        int result = validateStudent(id, name, group);
        assertEquals(result, 0); // Failure (0) expected
    }

    public void testCase3() {
        String id = "";
        String name = "Name";
        int group = 203;

        int result = validateStudent(id, name, group);
        assertEquals(result, 0); // Failure (0) expected
    }

    public void testCase4() {
        String id = "s2";
        String name = "";
        int group = 203;

        int result = validateStudent(id, name, group);
        assertEquals(result, 0); // Failure (0) expected
    }

    public void testCase5() {
        String id = "s2"; // Assuming it already exists
        String name = "acs";
        int group = 320;

        int result = validateStudent(id, name, group);
        assertEquals(result, 0); // Failure (0) expected
    }

    public void testCase6() {
        String id = "S2";
        String name = "Jane Smith";
        int group = -102;

        int result = validateStudent(id, name, group);
        assertEquals(result, 0); // Failure (0) expected
    }

    public void testCase7() {
        String id = "S2";
        String name = "Jane Smith";
        Integer group = null;

        int result = validateStudent(id, name, group);
        assertEquals(result, 0); // Failure (0) expected
    }

    public void testCase8() {
        String id = "S2";
        String name = "Jane Smith";
        int group = 110;

        int result = validateStudent(id, name, group);
        assertEquals(result, 0); // Failure (0) expected
    }

    public void testCase9() {
        String id = "S2";
        String name = "Jane Smith";
        int group = 938;

        int result = validateStudent(id, name, group);
        assertEquals(result, 0); // Failure (0) expected
    }

    public void testCase10() {
        String id = "S2";
        String name = "John Doe";
        int group = 111;

        int result = validateStudent(id, name, group);
        assertEquals(result, 1); // Success (1) expected
    }

    public void testCase11() {
        String id = "S3";
        String name = "John Doe";
        int group = 937;

        int result = validateStudent(id, name, group);
        assertEquals(result, 1); // Success (1) expected
    }

    private int validateStudent(String id, String name, Integer group) {
        try {
            return service.saveStudent(id, name, group);
        } catch(NullPointerException n){
            System.out.println(n);
            return 0;
        }
    }

}

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
public class AddAssignmentTest
        extends TestCase
{
    private Service service;


    public AddAssignmentTest( String testName )
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
        return new TestSuite( AddAssignmentTest.class );
    }

    public void testCase1() {
        String id = "A1";
        String descriere = "lab1";
        int startline=2;
        int deadline = 10;

        int result = validateAssignment(id, descriere,deadline,startline);
        assertEquals(result, 1); // Success (1) expected
    }

    public void testCase2() {
        String id = "A1"; //A1 already exists
        String descriere = "lab2";
        int startline=2;
        int deadline = 10;

        int result = validateAssignment(id, descriere,deadline,startline);
        assertEquals(result, 0); // Failure (0) expected

    }

    public void testCase3() {
        String id = "";
        String descriere = "lab2";
        int startline=2;
        int deadline = 10;

        int result = validateAssignment(id, descriere,deadline,startline);
        assertEquals(result, 0); // Failure (0) expected

    }
    public void testCase4() {
        String id = null;
        String descriere = "lab2";
        int startline=2;
        int deadline = 10;

        int result = validateAssignment(id, descriere,deadline,startline);
        assertEquals(result, 0); // Failure (0) expected

    }
    public void testCase5() {
        String id = "A2";
        String descriere = "";
        int startline=2;
        int deadline = 10;

        int result = validateAssignment(id, descriere,deadline,startline);
        assertEquals(result, 0); // Failure (0) expected

    }
    public void testCase6() {
        String id = "A2";
        String descriere = null;
        int startline=2;
        int deadline = 10;

        int result = validateAssignment(id, descriere,deadline,startline);
        assertEquals(result, 0); // Failure (0) expected

    }
    public void testCase7() {
        String id = "A2";
        String descriere = "Lab_2";
        int startline=0;
        int deadline = 10;

        int result = validateAssignment(id, descriere,deadline,startline);
        assertEquals(result, 0); // Failure (0) expected

    }
    public void testCase8() {
        String id = "A2";
        String descriere = "Lab_2";
        int startline=2;
        int deadline = 15;

        int result = validateAssignment(id, descriere,deadline,startline);
        assertEquals(result, 0); // Failure (0) expected

    }
    public void testCase9() {
        String id = "A2";
        String descriere = "Lab_2";
        Integer startline=null;
        int deadline = 10;

        int result = validateAssignment(id, descriere,deadline,startline);
        assertEquals(result, 0); // Failure (0) expected

    }
    public void testCase10() {
        String id = "A2";
        String descriere = "Lab_2";
        Integer startline=2;
        Integer deadline = null;

        int result = validateAssignment(id, descriere,deadline,startline);
        assertEquals(result, 0); // Failure (0) expected

    }

    private int validateAssignment(String id, String descriere, int deadline, int startline) {
        try {
            return service.saveTema(id, descriere, deadline,startline);
        } catch(NullPointerException n){
            System.out.println(n);
            return 0;
        }

    }

}

package com.example.vetcli;

import com.example.vetcli.model.Doctors;
import com.example.vetcli.service.impl.AppointmentServiceImpl;
import com.example.vetcli.service.impl.DoctorServiceImpl;
import com.example.vetcli.service.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class VetcliApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(VetcliApplication.class, args);
        DoctorServiceImpl doctorService = applicationContext.getBean(DoctorServiceImpl.class);
        PatientServiceImpl patientService = applicationContext.getBean(PatientServiceImpl.class);
        AppointmentServiceImpl appointmentService = applicationContext.getBean(AppointmentServiceImpl.class);
        Scanner sc = new Scanner(System.in);
        Scanner fs = new Scanner(System.in);
        String fio;
        String spec;
        System.out.println("Добро пожаловать в ветклинику. Пройдите авторизацию");
        int choice = Logging.login();

        if(choice == 19){
            System.out.println("Поздравляем вход успешен!");
            System.out.println("Панель управления \n" +
                    "1 - Создать доктора \n" +
                    "2 - Просмотр всех докторов \n" +
                    "3 - Обновления данных доктора \n" +
                    "4 - Удаление данных доктора \n" +
                    "5 - Добавить клиента \n" +
                    "6 - Просмотр всех клиентов \n" +
                    "7 - Обновления данных клиента \n" +
                    "8 - Удаление клиента \n " +
                    "9 - Добавить прием к врачу \n" +
                    "10 - Список всех приемов \n" +
                    "11 - Изменить статус приема \n" +
                    "12 - Удалить прием \n" +
                    "13 - Все приемы одного клиента \n" +
                    "14 - Все приемы одного доктора \n" +
                    "Для выхода введите 0");
            choice = sc.nextInt();
        } else {
            System.out.println("Вход не выполнен");
            choice = 0;
        }



        while (choice != 0) {

            switch (choice) {

                case 1:
                    System.out.println("Введите ФИО доктора");
                    fio = fs.nextLine();
                    System.out.println("Введите специализацию");
                    spec = fs.nextLine();
                    doctorService.addDoc(fio, spec);
                    break;
                case 2:
                    doctorService.findAll();
                    break;
                case 3:
                    doctorService.findAll();
                    System.out.println("Выберете и впешите id доктора, чьи данные вы хотите изменить");
                    Integer num = sc.nextInt();
                    Doctors doctors = doctorService.findDocById(num);
                    System.out.println("Измените ФИО доктора");
                    fio = fs.nextLine();
                    System.out.println("Измените специализацию доктора");
                    spec = fs.nextLine();
                    doctorService.updateDoc(doctors, fio, spec);
                    break;
                case 4:
                    doctorService.findAll();
                    System.out.println("Выберете и впешите id доктора, чьи данные вы хотите удалить");
                    num = sc.nextInt();
                    doctorService.deleteDoc(num);
                    break;
                case 5:
                    System.out.println("Введите имя клиента");
                    fio = fs.nextLine();
                    patientService.addPat(fio);
                    break;
                case 6:
                    patientService.findAllPat();
                    break;
                case 7:
                    patientService.findAllPat();
                    System.out.println("Выберете и впешите id клиента, чьи данные вы хотите изменить");
                    num = sc.nextInt();
                    System.out.println("Измените имя клиента");
                    fio = fs.nextLine();
                    patientService.updatePat(patientService.findPatById(num), fio);
                    break;
                case 8:
                    patientService.findAllPat();
                    System.out.println("Выберете и впешите id клиента, чьи данные вы хотите удалить");
                    num = sc.nextInt();
                    patientService.deletePat(num);
                    break;
                case 9:
                    doctorService.findAll();
                    System.out.println("Введите ФИО доктора");
                    fio = fs.nextLine();
                    patientService.findAllPat();
                    System.out.println("Введите имя клиента");
                    String name = fs.nextLine();
                    System.out.println("Введите дату приема");
                    String date = fs.nextLine();
                    System.out.println("Введите время приема");
                    String time = fs.nextLine();
                    appointmentService.createAppoint(fio, name, date, time, "назначен");
                    break;
                case 10:
                    appointmentService.findAllAppoint();
                    break;
                case 11:
                    appointmentService.findAllAppoint();
                    System.out.println("Выберете и впешите номер приема статус которого вы хотите изменить");
                    num = sc.nextInt();
                    System.out.println("Измените статус");
                    String stat = fs.nextLine();
                    appointmentService.updateStatus(appointmentService.findAppointById(num), stat);
                    break;
                case 12:
                    appointmentService.findAllAppoint();
                    System.out.println("Выберете и впешите номер приема, который вы хотите удалить");
                    num = sc.nextInt();
                    appointmentService.deleteAppoint(num);
                    break;
                case 13:
                    appointmentService.findAllAppoint();
                    System.out.println("Выберете и выпешите имя клиента");
                    name = fs.nextLine();
                    appointmentService.findAllAppointByPat(appointmentService.findPatientByName(name));
                    break;
                case 14:
                    appointmentService.findAllAppoint();
                    System.out.println("Выберете и выпешете ФИО доктора");
                    fio=fs.nextLine();
                    appointmentService.findAllAppointByDoc(appointmentService.findDoctorByFio(fio));
                    break;
            }
            choice = sc.nextInt();

        }
    }

}

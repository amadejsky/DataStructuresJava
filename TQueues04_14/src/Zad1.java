import lib.TaskManager;

import java.util.Scanner;

public class Zad1{
    public static void main(String[] args) {
        partB();
    }

    public static void partB(){
        TaskManager man = new TaskManager();
        man.addTask("eat");
        man.addTask("sleep");
        man.addTask("code");
        man.addTask("repeat");

        boolean continueActing = true;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("###########################");
            System.out.println(man.toString());
            System.out.println("ybierz opcje");
            System.out.println("1. Dodaj zadanie");
            System.out.println("2 Usuń zadanie");
            System.out.println("3 Zakoncz");
            if(sc.hasNextInt()){
                String tmp = sc.nextLine();
                int choosenNum = Integer.parseInt(tmp);
                switch(choosenNum) {
                    case 1:
                        System.out.println("Podaj nowe zadanie");
                        String newTask = sc.nextLine();
                        man.addTask(newTask);
                        break;
                    case 2:
                        man.deleteTask();
                        break;
                    case 3:
                        continueActing = false;
                        break;
                    default:
                        continue;
                }
                }else{
                    sc.nextLine();
                }
            }while(continueActing);
        }
    }





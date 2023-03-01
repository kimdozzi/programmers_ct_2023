package com.ll.CodeUp.p1805;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        List<Device> devices = new ArrayList<>();


        for(int i = 0; i < T; i++) {
            int no = sc.nextInt();
            int gas = sc.nextInt();
            devices.add(new Device(no, gas));
        }
        /*
        System.out.println(devices);
        devices.sort(Comparator.comparing(Device::getId));
        for(int i = 0; i < devices.size(); i++) {
            System.out.println(devices.get(i).getId()+ " " +devices.get(i).getGas());
        }
        */

        /*
        devices = devices
                .stream()
                .sorted((e1,e2) -> e1.getId() - e2.getId())
                .collect(Collectors.toList());
        for(Device device : devices)
            System.out.printf("%d %d\n", device.getId(), device.getGas());
        */

        String output = devices
                .stream()
                .sorted(Comparator.comparingInt(Device::getId))
                //.map(e -> "%d %d".formatted(e.getId(), e.getGas()))
                .map(e -> e.getId() + " " + e.getGas())
                .collect(Collectors.joining("\n"));
        System.out.println(output);

        sc.close();
    }
}

class Device {
    private int id;
    private int gas;
    public Device(int id, int gas) {
        this.id = id;
        this.gas = gas;
    }
    public int getId() {
        return id;
    }
    public int getGas() {
        return gas;
    }
}
package com.example.demo.bootStrap;
import com.example.demo.entities.*;
import com.example.demo.dao.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final customerRepository customerRepository;
    private final divisionRepository divisionRepository;
    public BootStrapData(customerRepository customerRepository,divisionRepository divisionRepository){
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... agrs) throws Exception{
        customer caitin = new customer();
        caitin.setFirstName("Caitlin");
        caitin.setLastName("Ivey");
        caitin.setAddress("3131 Mountain Creek Rd.");
        caitin.setPostal_code("37122");
        caitin.setPhone("6158901454");

        customer erika = new customer();
        erika.setFirstName("Erika");
        erika.setLastName("Smith");
        erika.setAddress("31 Karen Dr.");
        erika.setPostal_code("37123");
        erika.setPhone("7623451234");

        customer sarin = new customer();
        sarin.setFirstName("Sarin");
        sarin.setLastName("Hill");
        sarin.setAddress("545 Loose Lane.");
        sarin.setPostal_code("53122");
        sarin.setPhone("6155431234");

        customer bobby = new customer();
        bobby.setFirstName("Bobby");
        bobby.setLastName("Graham");
        bobby.setAddress("119 Winding Rd.");
        bobby.setPostal_code("37321");
        bobby.setPhone("6159087423");

        customer john = new customer();
        john.setFirstName("John");
        john.setLastName("Parker");
        john.setAddress("786 Lookout Mountain");
        john.setPostal_code("37133");
        john.setPhone("6155431234");

        if( customerRepository.count() == 0 || customerRepository.count() == 1)  {
        customerRepository.save(caitin);
            customerRepository.save(erika);
            customerRepository.save(bobby);
            customerRepository.save(sarin);
            customerRepository.save(john);
        }
        }
    }


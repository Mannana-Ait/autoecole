package com.ird.faa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.stream.Stream;

import com.ird.faa.security.common.AuthoritiesConstants;
import com.ird.faa.security.bean.User;
import com.ird.faa.security.bean.Permission;
import com.ird.faa.security.bean.Role;
import com.ird.faa.security.service.facade.UserService;
import com.ird.faa.security.service.facade.RoleService;
import com.ird.faa.bean.Chercheur;


@SpringBootApplication
public class FaaApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(FaaApplication.class, args);
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
        return (args) -> {
            if (true) {
                Map<String, String> etats = new HashMap<>();
                etats.put("Initialisé", "initialise");
                etats.put("En cours", "encours");
                etats.put("Terminé", "termine");


                // Role chercheur
                Chercheur userForChercheur = new Chercheur("chercheur");

                Role roleForChercheur = new Role();
                roleForChercheur.setAuthority(AuthoritiesConstants.CHERCHEUR);
                List<Permission> permissionsForChercheur = new ArrayList<>();
                addPermissionForChercheur(permissionsForChercheur);
                roleForChercheur.setPermissions(permissionsForChercheur);
                if (userForChercheur.getRoles() == null)
                    userForChercheur.setRoles(new ArrayList<>());

                userForChercheur.getRoles().add(roleForChercheur);
                userService.save(userForChercheur);


                // Role admin
                User userForAdmin = new User("admin");

                Role roleForAdmin = new Role();
                roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
                List<Permission> permissionsForAdmin = new ArrayList<>();
                addPermissionForAdmin(permissionsForAdmin);
                roleForAdmin.setPermissions(permissionsForAdmin);
                if (userForAdmin.getRoles() == null)
                    userForAdmin.setRoles(new ArrayList<>());

                userForAdmin.getRoles().add(roleForAdmin);
                userService.save(userForAdmin);
            }
        };
    }

    private static void addPermissionForChercheur(List<Permission> permissions) {
        permissions.add(new Permission("EtatMessage.edit"));
        permissions.add(new Permission("EtatMessage.list"));
        permissions.add(new Permission("EtatMessage.view"));
        permissions.add(new Permission("EtatMessage.add"));
        permissions.add(new Permission("EtatMessage.delete"));
        permissions.add(new Permission("Jour.edit"));
        permissions.add(new Permission("Jour.list"));
        permissions.add(new Permission("Jour.view"));
        permissions.add(new Permission("Jour.add"));
        permissions.add(new Permission("Jour.delete"));
        permissions.add(new Permission("Message.edit"));
        permissions.add(new Permission("Message.list"));
        permissions.add(new Permission("Message.view"));
        permissions.add(new Permission("Message.add"));
        permissions.add(new Permission("Message.delete"));
        permissions.add(new Permission("AvisVisiteur.edit"));
        permissions.add(new Permission("AvisVisiteur.list"));
        permissions.add(new Permission("AvisVisiteur.view"));
        permissions.add(new Permission("AvisVisiteur.add"));
        permissions.add(new Permission("AvisVisiteur.delete"));
        permissions.add(new Permission("MoniteurTheorique.edit"));
        permissions.add(new Permission("MoniteurTheorique.list"));
        permissions.add(new Permission("MoniteurTheorique.view"));
        permissions.add(new Permission("MoniteurTheorique.add"));
        permissions.add(new Permission("MoniteurTheorique.delete"));
        permissions.add(new Permission("Gender.edit"));
        permissions.add(new Permission("Gender.list"));
        permissions.add(new Permission("Gender.view"));
        permissions.add(new Permission("Gender.add"));
        permissions.add(new Permission("Gender.delete"));
        permissions.add(new Permission("CategoriePermis.edit"));
        permissions.add(new Permission("CategoriePermis.list"));
        permissions.add(new Permission("CategoriePermis.view"));
        permissions.add(new Permission("CategoriePermis.add"));
        permissions.add(new Permission("CategoriePermis.delete"));
        permissions.add(new Permission("Ecole.edit"));
        permissions.add(new Permission("Ecole.list"));
        permissions.add(new Permission("Ecole.view"));
        permissions.add(new Permission("Ecole.add"));
        permissions.add(new Permission("Ecole.delete"));
        permissions.add(new Permission("Permis.edit"));
        permissions.add(new Permission("Permis.list"));
        permissions.add(new Permission("Permis.view"));
        permissions.add(new Permission("Permis.add"));
        permissions.add(new Permission("Permis.delete"));
        permissions.add(new Permission("Marque.edit"));
        permissions.add(new Permission("Marque.list"));
        permissions.add(new Permission("Marque.view"));
        permissions.add(new Permission("Marque.add"));
        permissions.add(new Permission("Marque.delete"));
        permissions.add(new Permission("Vehicule.edit"));
        permissions.add(new Permission("Vehicule.list"));
        permissions.add(new Permission("Vehicule.view"));
        permissions.add(new Permission("Vehicule.add"));
        permissions.add(new Permission("Vehicule.delete"));
        permissions.add(new Permission("MoniteurPratique.edit"));
        permissions.add(new Permission("MoniteurPratique.list"));
        permissions.add(new Permission("MoniteurPratique.view"));
        permissions.add(new Permission("MoniteurPratique.add"));
        permissions.add(new Permission("MoniteurPratique.delete"));
        permissions.add(new Permission("TypeVehicule.edit"));
        permissions.add(new Permission("TypeVehicule.list"));
        permissions.add(new Permission("TypeVehicule.view"));
        permissions.add(new Permission("TypeVehicule.add"));
        permissions.add(new Permission("TypeVehicule.delete"));
        permissions.add(new Permission("TypeAvis.edit"));
        permissions.add(new Permission("TypeAvis.list"));
        permissions.add(new Permission("TypeAvis.view"));
        permissions.add(new Permission("TypeAvis.add"));
        permissions.add(new Permission("TypeAvis.delete"));
        permissions.add(new Permission("Chercheur.edit"));
        permissions.add(new Permission("Chercheur.list"));
        permissions.add(new Permission("Chercheur.view"));
        permissions.add(new Permission("Chercheur.add"));
        permissions.add(new Permission("Chercheur.delete"));
        permissions.add(new Permission("PlanningItem.edit"));
        permissions.add(new Permission("PlanningItem.list"));
        permissions.add(new Permission("PlanningItem.view"));
        permissions.add(new Permission("PlanningItem.add"));
        permissions.add(new Permission("PlanningItem.delete"));
        permissions.add(new Permission("Gerant.edit"));
        permissions.add(new Permission("Gerant.list"));
        permissions.add(new Permission("Gerant.view"));
        permissions.add(new Permission("Gerant.add"));
        permissions.add(new Permission("Gerant.delete"));
        permissions.add(new Permission("Ville.edit"));
        permissions.add(new Permission("Ville.list"));
        permissions.add(new Permission("Ville.view"));
        permissions.add(new Permission("Ville.add"));
        permissions.add(new Permission("Ville.delete"));
    }

    private static void addPermissionForAdmin(List<Permission> permissions) {
        permissions.add(new Permission("EtatMessage.edit"));
        permissions.add(new Permission("EtatMessage.list"));
        permissions.add(new Permission("EtatMessage.view"));
        permissions.add(new Permission("EtatMessage.add"));
        permissions.add(new Permission("EtatMessage.delete"));
        permissions.add(new Permission("Jour.edit"));
        permissions.add(new Permission("Jour.list"));
        permissions.add(new Permission("Jour.view"));
        permissions.add(new Permission("Jour.add"));
        permissions.add(new Permission("Jour.delete"));
        permissions.add(new Permission("Message.edit"));
        permissions.add(new Permission("Message.list"));
        permissions.add(new Permission("Message.view"));
        permissions.add(new Permission("Message.add"));
        permissions.add(new Permission("Message.delete"));
        permissions.add(new Permission("AvisVisiteur.edit"));
        permissions.add(new Permission("AvisVisiteur.list"));
        permissions.add(new Permission("AvisVisiteur.view"));
        permissions.add(new Permission("AvisVisiteur.add"));
        permissions.add(new Permission("AvisVisiteur.delete"));
        permissions.add(new Permission("MoniteurTheorique.edit"));
        permissions.add(new Permission("MoniteurTheorique.list"));
        permissions.add(new Permission("MoniteurTheorique.view"));
        permissions.add(new Permission("MoniteurTheorique.add"));
        permissions.add(new Permission("MoniteurTheorique.delete"));
        permissions.add(new Permission("Gender.edit"));
        permissions.add(new Permission("Gender.list"));
        permissions.add(new Permission("Gender.view"));
        permissions.add(new Permission("Gender.add"));
        permissions.add(new Permission("Gender.delete"));
        permissions.add(new Permission("CategoriePermis.edit"));
        permissions.add(new Permission("CategoriePermis.list"));
        permissions.add(new Permission("CategoriePermis.view"));
        permissions.add(new Permission("CategoriePermis.add"));
        permissions.add(new Permission("CategoriePermis.delete"));
        permissions.add(new Permission("Ecole.edit"));
        permissions.add(new Permission("Ecole.list"));
        permissions.add(new Permission("Ecole.view"));
        permissions.add(new Permission("Ecole.add"));
        permissions.add(new Permission("Ecole.delete"));
        permissions.add(new Permission("Permis.edit"));
        permissions.add(new Permission("Permis.list"));
        permissions.add(new Permission("Permis.view"));
        permissions.add(new Permission("Permis.add"));
        permissions.add(new Permission("Permis.delete"));
        permissions.add(new Permission("Marque.edit"));
        permissions.add(new Permission("Marque.list"));
        permissions.add(new Permission("Marque.view"));
        permissions.add(new Permission("Marque.add"));
        permissions.add(new Permission("Marque.delete"));
        permissions.add(new Permission("Vehicule.edit"));
        permissions.add(new Permission("Vehicule.list"));
        permissions.add(new Permission("Vehicule.view"));
        permissions.add(new Permission("Vehicule.add"));
        permissions.add(new Permission("Vehicule.delete"));
        permissions.add(new Permission("MoniteurPratique.edit"));
        permissions.add(new Permission("MoniteurPratique.list"));
        permissions.add(new Permission("MoniteurPratique.view"));
        permissions.add(new Permission("MoniteurPratique.add"));
        permissions.add(new Permission("MoniteurPratique.delete"));
        permissions.add(new Permission("TypeVehicule.edit"));
        permissions.add(new Permission("TypeVehicule.list"));
        permissions.add(new Permission("TypeVehicule.view"));
        permissions.add(new Permission("TypeVehicule.add"));
        permissions.add(new Permission("TypeVehicule.delete"));
        permissions.add(new Permission("TypeAvis.edit"));
        permissions.add(new Permission("TypeAvis.list"));
        permissions.add(new Permission("TypeAvis.view"));
        permissions.add(new Permission("TypeAvis.add"));
        permissions.add(new Permission("TypeAvis.delete"));
        permissions.add(new Permission("Chercheur.edit"));
        permissions.add(new Permission("Chercheur.list"));
        permissions.add(new Permission("Chercheur.view"));
        permissions.add(new Permission("Chercheur.add"));
        permissions.add(new Permission("Chercheur.delete"));
        permissions.add(new Permission("PlanningItem.edit"));
        permissions.add(new Permission("PlanningItem.list"));
        permissions.add(new Permission("PlanningItem.view"));
        permissions.add(new Permission("PlanningItem.add"));
        permissions.add(new Permission("PlanningItem.delete"));
        permissions.add(new Permission("Gerant.edit"));
        permissions.add(new Permission("Gerant.list"));
        permissions.add(new Permission("Gerant.view"));
        permissions.add(new Permission("Gerant.add"));
        permissions.add(new Permission("Gerant.delete"));
        permissions.add(new Permission("Ville.edit"));
        permissions.add(new Permission("Ville.list"));
        permissions.add(new Permission("Ville.view"));
        permissions.add(new Permission("Ville.add"));
        permissions.add(new Permission("Ville.delete"));
    }


}



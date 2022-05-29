package com.ird.faa.service.admin.impl;

import java.util.List;
import java.util.Date;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import com.ird.faa.bean.Ecole;
import com.ird.faa.bean.Ville;
import com.ird.faa.bean.Gerant;
import com.ird.faa.bean.Vehicule;
import com.ird.faa.bean.MoniteurTheorique;
import com.ird.faa.bean.MoniteurPratique;
import com.ird.faa.bean.PlanningItem;
import com.ird.faa.dao.EcoleDao;
import com.ird.faa.service.admin.facade.EcoleAdminService;
import com.ird.faa.service.admin.facade.VehiculeAdminService;
import com.ird.faa.service.admin.facade.PlanningItemAdminService;
import com.ird.faa.service.admin.facade.MoniteurPratiqueAdminService;
import com.ird.faa.service.admin.facade.MoniteurTheoriqueAdminService;
import com.ird.faa.service.admin.facade.VilleAdminService;
import com.ird.faa.service.admin.facade.GerantAdminService;

import com.ird.faa.ws.rest.provided.vo.EcoleVo;
import com.ird.faa.service.util.*;
import com.ird.faa.bean.Vehicule;
import com.ird.faa.service.admin.facade.VehiculeAdminService;
import com.ird.faa.bean.MoniteurTheorique;
import com.ird.faa.service.admin.facade.MoniteurTheoriqueAdminService;
import com.ird.faa.bean.MoniteurPratique;
import com.ird.faa.service.admin.facade.MoniteurPratiqueAdminService;
import com.ird.faa.bean.PlanningItem;
import com.ird.faa.service.admin.facade.PlanningItemAdminService;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EcoleAdminServiceImpl extends AbstractServiceImpl<Ecole> implements EcoleAdminService {

    @Autowired
    private EcoleDao ecoleDao;

    @Autowired
    private VehiculeAdminService vehiculeService;
    @Autowired
    private PlanningItemAdminService planningItemService;
    @Autowired
    private MoniteurPratiqueAdminService moniteurPratiqueService;
    @Autowired
    private MoniteurTheoriqueAdminService moniteurTheoriqueService;
    @Autowired
    private VilleAdminService villeService;
    @Autowired
    private GerantAdminService gerantService;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Ecole> findAll() {
        return ecoleDao.findAll();
    }

    @Override
    public List<Ecole> findByVilleReference(String reference) {
        return ecoleDao.findByVilleReference(reference);
    }

    @Override
    @Transactional
    public int deleteByVilleReference(String reference) {
        return ecoleDao.deleteByVilleReference(reference);
    }

    @Override
    public List<Ecole> findByVilleId(Long id) {
        return ecoleDao.findByVilleId(id);
    }

    @Override
    @Transactional
    public int deleteByVilleId(Long id) {
        return ecoleDao.deleteByVilleId(id);
    }


    @Override
    public List<Ecole> findByGerantReference(String reference) {
        return ecoleDao.findByGerantReference(reference);
    }

    @Override
    @Transactional
    public int deleteByGerantReference(String reference) {
        return ecoleDao.deleteByGerantReference(reference);
    }

    @Override
    public List<Ecole> findByGerantId(Long id) {
        return ecoleDao.findByGerantId(id);
    }

    @Override
    @Transactional
    public int deleteByGerantId(Long id) {
        return ecoleDao.deleteByGerantId(id);
    }

    @Override
    public Ecole findByReference(String reference) {
        if (reference == null) return null;
        return ecoleDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return ecoleDao.deleteByReference(reference);
    }

    @Override
    public Ecole findByIdOrReference(Ecole ecole) {
        Ecole resultat = null;
        if (ecole != null) {
            if (StringUtil.isNotEmpty(ecole.getId())) {
                resultat = ecoleDao.getOne(ecole.getId());
            } else if (StringUtil.isNotEmpty(ecole.getReference())) {
                resultat = ecoleDao.findByReference(ecole.getReference());
            }
        }
        return resultat;
    }

    @Override
    public Ecole findById(Long id) {
        if (id == null) return null;
        return ecoleDao.getOne(id);
    }

    @Override
    public Ecole findByIdWithAssociatedList(Long id) {
        Ecole ecole = findById(id);
        findAssociatedLists(ecole);
        return ecole;
    }

    private void findAssociatedLists(Ecole ecole) {
        if (ecole != null && ecole.getId() != null) {
            List<Vehicule> vehicules = vehiculeService.findByEcoleId(ecole.getId());
            ecole.setVehicules(vehicules);
            List<MoniteurTheorique> moniteurTheoriques = moniteurTheoriqueService.findByEcoleId(ecole.getId());
            ecole.setMoniteurTheoriques(moniteurTheoriques);
            List<MoniteurPratique> moniteurPratiques = moniteurPratiqueService.findByEcoleId(ecole.getId());
            ecole.setMoniteurPratiques(moniteurPratiques);
            List<PlanningItem> planningItems = planningItemService.findByEcoleId(ecole.getId());
            ecole.setPlanningItems(planningItems);
        }
    }

    private void deleteAssociatedLists(Long id) {
        if (id != null) {
            vehiculeService.deleteByEcoleId(id);
            moniteurTheoriqueService.deleteByEcoleId(id);
            moniteurPratiqueService.deleteByEcoleId(id);
            planningItemService.deleteByEcoleId(id);
        }
    }

    private void updateAssociatedLists(Ecole ecole) {
        if (ecole != null && ecole.getId() != null) {
            List
                    <List<Vehicule>> resultVehicules = vehiculeService.getToBeSavedAndToBeDeleted(vehiculeService.findByEcoleId(ecole.getId()), ecole.getVehicules());
            vehiculeService.delete(resultVehicules.get(1));
            associateVehicule(ecole, resultVehicules.get(0));
            vehiculeService.update(resultVehicules.get(0));

            List
                    <List<MoniteurTheorique>> resultMoniteurTheoriques = moniteurTheoriqueService.getToBeSavedAndToBeDeleted(moniteurTheoriqueService.findByEcoleId(ecole.getId()), ecole.getMoniteurTheoriques());
            moniteurTheoriqueService.delete(resultMoniteurTheoriques.get(1));
            associateMoniteurTheorique(ecole, resultMoniteurTheoriques.get(0));
            moniteurTheoriqueService.update(resultMoniteurTheoriques.get(0));

            List
                    <List<MoniteurPratique>> resultMoniteurPratiques = moniteurPratiqueService.getToBeSavedAndToBeDeleted(moniteurPratiqueService.findByEcoleId(ecole.getId()), ecole.getMoniteurPratiques());
            moniteurPratiqueService.delete(resultMoniteurPratiques.get(1));
            associateMoniteurPratique(ecole, resultMoniteurPratiques.get(0));
            moniteurPratiqueService.update(resultMoniteurPratiques.get(0));

            List
                    <List<PlanningItem>> resultPlanningItems = planningItemService.getToBeSavedAndToBeDeleted(planningItemService.findByEcoleId(ecole.getId()), ecole.getPlanningItems());
            planningItemService.delete(resultPlanningItems.get(1));
            associatePlanningItem(ecole, resultPlanningItems.get(0));
            planningItemService.update(resultPlanningItems.get(0));

        }
    }

    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (ecoleDao.findById(id).isPresent()) {
            deleteAssociatedLists(id);
            ecoleDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public Ecole update(Ecole ecole) {
        Ecole foundedEcole = findById(ecole.getId());
        if (foundedEcole == null) return null;
        else {
            updateAssociatedLists(ecole);
            return ecoleDao.save(ecole);
        }
    }

    @Override
    public Ecole save(Ecole ecole) {

        Ecole result = null;
        Ecole foundedEcole = findByReference(ecole.getReference());
        if (foundedEcole == null) {


            findVille(ecole);
            findGerant(ecole);

            Ecole savedEcole = ecoleDao.save(ecole);

            saveVehicules(savedEcole, ecole.getVehicules());
            saveMoniteurTheoriques(savedEcole, ecole.getMoniteurTheoriques());
            saveMoniteurPratiques(savedEcole, ecole.getMoniteurPratiques());
            savePlanningItems(savedEcole, ecole.getPlanningItems());
            result = savedEcole;
        }

        return result;
    }

    @Override
    public List<Ecole> save(List<Ecole> ecoles) {
        List<Ecole> list = new ArrayList<>();
        for (Ecole ecole : ecoles) {
            list.add(save(ecole));
        }
        return list;
    }

    private List<Vehicule> prepareVehicules(Ecole ecole, List<Vehicule> vehicules) {
        for (Vehicule vehicule : vehicules) {
            vehicule.setEcole(ecole);
        }
        return vehicules;
    }


    @Override
    @Transactional
    public int delete(Ecole ecole) {
        if (ecole.getReference() == null) return -1;

        Ecole foundedEcole = findByReference(ecole.getReference());
        if (foundedEcole == null) return -1;
        ecoleDao.delete(foundedEcole);
        return 1;
    }


    public List<Ecole> findByCriteria(EcoleVo ecoleVo) {

        String query = "SELECT o FROM Ecole o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", ecoleVo.getId());
        query += SearchUtil.addConstraint("o", "reference", "LIKE", ecoleVo.getReference());
        query += SearchUtil.addConstraint("o", "altitude", "=", ecoleVo.getAltitude());
        query += SearchUtil.addConstraint("o", "angitude", "=", ecoleVo.getAngitude());
        query += SearchUtil.addConstraint("o", "nom", "LIKE", ecoleVo.getNom());
        query += SearchUtil.addConstraint("o", "address", "LIKE", ecoleVo.getAddress());
        query += SearchUtil.addConstraint("o", "numAutorisation", "LIKE", ecoleVo.getNumAutorisation());
        query += SearchUtil.addConstraint("o", "numFix", "LIKE", ecoleVo.getNumFix());
        query += SearchUtil.addConstraint("o", "numPhone", "LIKE", ecoleVo.getNumPhone());
        query += SearchUtil.addConstraint("o", "email", "LIKE", ecoleVo.getEmail());
        query += SearchUtil.addConstraint("o", "tauxReussite", "=", ecoleVo.getTauxReussite());
        query += SearchUtil.addConstraintDate("o", "dateCreation", "=", ecoleVo.getDateCreation());
        query += SearchUtil.addConstraintDate("o", "dateAbonnement", "=", ecoleVo.getDateAbonnement());
        query += SearchUtil.addConstraintMinMax("o", "altitude", ecoleVo.getAltitudeMin(), ecoleVo.getAltitudeMax());
        query += SearchUtil.addConstraintMinMax("o", "angitude", ecoleVo.getAngitudeMin(), ecoleVo.getAngitudeMax());
        query += SearchUtil.addConstraintMinMax("o", "tauxReussite", ecoleVo.getTauxReussiteMin(), ecoleVo.getTauxReussiteMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateCreation", ecoleVo.getDateCreationMin(), ecoleVo.getDateCreationMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateAbonnement", ecoleVo.getDateAbonnementMin(), ecoleVo.getDateAbonnementMax());
        if (ecoleVo.getVilleVo() != null) {
            query += SearchUtil.addConstraint("o", "ville.id", "=", ecoleVo.getVilleVo().getId());
            query += SearchUtil.addConstraint("o", "ville.reference", "LIKE", ecoleVo.getVilleVo().getReference());
        }

        if (ecoleVo.getGerantVo() != null) {
            query += SearchUtil.addConstraint("o", "gerant.id", "=", ecoleVo.getGerantVo().getId());
            query += SearchUtil.addConstraint("o", "gerant.reference", "LIKE", ecoleVo.getGerantVo().getReference());
        }

        return entityManager.createQuery(query).getResultList();
    }

    private void saveVehicules(Ecole ecole, List<Vehicule> vehicules) {

        if (ListUtil.isNotEmpty(ecole.getVehicules())) {
            List<Vehicule> savedVehicules = new ArrayList<>();
            vehicules.forEach(element -> {
                element.setEcole(ecole);
                vehiculeService.save(element);
            });
            ecole.setVehicules(savedVehicules);
        }
    }

    private void saveMoniteurTheoriques(Ecole ecole, List<MoniteurTheorique> moniteurTheoriques) {

        if (ListUtil.isNotEmpty(ecole.getMoniteurTheoriques())) {
            List<MoniteurTheorique> savedMoniteurTheoriques = new ArrayList<>();
            moniteurTheoriques.forEach(element -> {
                element.setEcole(ecole);
                moniteurTheoriqueService.save(element);
            });
            ecole.setMoniteurTheoriques(savedMoniteurTheoriques);
        }
    }

    private void saveMoniteurPratiques(Ecole ecole, List<MoniteurPratique> moniteurPratiques) {

        if (ListUtil.isNotEmpty(ecole.getMoniteurPratiques())) {
            List<MoniteurPratique> savedMoniteurPratiques = new ArrayList<>();
            moniteurPratiques.forEach(element -> {
                element.setEcole(ecole);
                moniteurPratiqueService.save(element);
            });
            ecole.setMoniteurPratiques(savedMoniteurPratiques);
        }
    }

    private void savePlanningItems(Ecole ecole, List<PlanningItem> planningItems) {

        if (ListUtil.isNotEmpty(ecole.getPlanningItems())) {
            List<PlanningItem> savedPlanningItems = new ArrayList<>();
            planningItems.forEach(element -> {
                element.setEcole(ecole);
                planningItemService.save(element);
            });
            ecole.setPlanningItems(savedPlanningItems);
        }
    }

    private void findVille(Ecole ecole) {
        Ville loadedVille = villeService.findByIdOrReference(ecole.getVille());

        if (loadedVille == null) {
            return;
        }
        ecole.setVille(loadedVille);
    }

    private void findGerant(Ecole ecole) {
        Gerant loadedGerant = gerantService.findByIdOrReference(ecole.getGerant());

        if (loadedGerant == null) {
            return;
        }
        ecole.setGerant(loadedGerant);
    }

    @Override
    @Transactional
    public void delete(List<Ecole> ecoles) {
        if (ListUtil.isNotEmpty(ecoles)) {
            ecoles.forEach(e -> ecoleDao.delete(e));
        }
    }

    @Override
    public void update(List<Ecole> ecoles) {
        if (ListUtil.isNotEmpty(ecoles)) {
            ecoles.forEach(e -> ecoleDao.save(e));
        }
    }

    private void associateVehicule(Ecole ecole, List<Vehicule> vehicule) {
        if (ListUtil.isNotEmpty(vehicule)) {
            vehicule.forEach(e -> e.setEcole(ecole));
        }
    }

    private void associateMoniteurTheorique(Ecole ecole, List<MoniteurTheorique> moniteurTheorique) {
        if (ListUtil.isNotEmpty(moniteurTheorique)) {
            moniteurTheorique.forEach(e -> e.setEcole(ecole));
        }
    }

    private void associateMoniteurPratique(Ecole ecole, List<MoniteurPratique> moniteurPratique) {
        if (ListUtil.isNotEmpty(moniteurPratique)) {
            moniteurPratique.forEach(e -> e.setEcole(ecole));
        }
    }

    private void associatePlanningItem(Ecole ecole, List<PlanningItem> planningItem) {
        if (ListUtil.isNotEmpty(planningItem)) {
            planningItem.forEach(e -> e.setEcole(ecole));
        }
    }


}

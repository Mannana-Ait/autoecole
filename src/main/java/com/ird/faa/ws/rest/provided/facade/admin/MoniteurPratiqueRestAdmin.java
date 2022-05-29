package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.MoniteurPratiqueAdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.ird.faa.bean.MoniteurPratique;
import com.ird.faa.ws.rest.provided.converter.MoniteurPratiqueConverter;
import com.ird.faa.ws.rest.provided.vo.MoniteurPratiqueVo;

@Api("Manages moniteurPratique services")
@RestController
@RequestMapping("api/admin/moniteurPratique")
public class MoniteurPratiqueRestAdmin {

    @Autowired
    private MoniteurPratiqueAdminService moniteurPratiqueService;

    @Autowired
    private MoniteurPratiqueConverter moniteurPratiqueConverter;


    @ApiOperation("Updates the specified  moniteurPratique")
    @PutMapping("/")
    public MoniteurPratiqueVo update(@RequestBody MoniteurPratiqueVo moniteurPratiqueVo) {
        MoniteurPratique moniteurPratique = moniteurPratiqueConverter.toItem(moniteurPratiqueVo);
        moniteurPratique = moniteurPratiqueService.update(moniteurPratique);
        return moniteurPratiqueConverter.toVo(moniteurPratique);
    }

    @ApiOperation("Finds a list of all moniteurPratiques")
    @GetMapping("/")
    public List<MoniteurPratiqueVo> findAll() {
        return moniteurPratiqueConverter.toVo(moniteurPratiqueService.findAll());
    }

    @ApiOperation("Finds a moniteurPratique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public MoniteurPratiqueVo findByIdWithAssociatedList(@PathVariable Long id) {
        return moniteurPratiqueConverter.toVo(moniteurPratiqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search moniteurPratique by a specific criteria")
    @PostMapping("/search")
    public List<MoniteurPratiqueVo> findByCriteria(@RequestBody MoniteurPratiqueVo moniteurPratiqueVo) {
        return moniteurPratiqueConverter.toVo(moniteurPratiqueService.findByCriteria(moniteurPratiqueVo));
    }

    @ApiOperation("Finds a moniteurPratique by id")
    @GetMapping("/id/{id}")
    public MoniteurPratiqueVo findById(@PathVariable Long id) {
        return moniteurPratiqueConverter.toVo(moniteurPratiqueService.findById(id));
    }

    @ApiOperation("Saves the specified  moniteurPratique")
    @PostMapping("/")
    public MoniteurPratiqueVo save(@RequestBody MoniteurPratiqueVo moniteurPratiqueVo) {
        MoniteurPratique moniteurPratique = moniteurPratiqueConverter.toItem(moniteurPratiqueVo);
        moniteurPratique = moniteurPratiqueService.save(moniteurPratique);
        return moniteurPratiqueConverter.toVo(moniteurPratique);
    }

    @ApiOperation("Delete the specified moniteurPratique")
    @DeleteMapping("/")
    public int delete(@RequestBody MoniteurPratiqueVo moniteurPratiqueVo) {
        MoniteurPratique moniteurPratique = moniteurPratiqueConverter.toItem(moniteurPratiqueVo);
        return moniteurPratiqueService.delete(moniteurPratique);
    }

    @ApiOperation("Deletes a moniteurPratique by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return moniteurPratiqueService.deleteById(id);
    }

    @ApiOperation("find by gender reference")
    @GetMapping("/gender/reference/{reference}")
    public List<MoniteurPratique> findByGenderReference(@PathVariable String reference) {
        return moniteurPratiqueService.findByGenderReference(reference);
    }

    @ApiOperation("delete by gender reference")
    @DeleteMapping("/gender/reference/{reference}")
    public int deleteByGenderReference(@PathVariable String reference) {
        return moniteurPratiqueService.deleteByGenderReference(reference);
    }

    @ApiOperation("find by gender id")
    @GetMapping("/gender/id/{id}")
    public List<MoniteurPratique> findByGenderId(@PathVariable Long id) {
        return moniteurPratiqueService.findByGenderId(id);
    }

    @ApiOperation("delete by gender id")
    @DeleteMapping("/gender/id/{id}")
    public int deleteByGenderId(@PathVariable Long id) {
        return moniteurPratiqueService.deleteByGenderId(id);
    }


}

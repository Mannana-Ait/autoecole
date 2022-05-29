package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.MoniteurTheoriqueChercheurService;

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
import com.ird.faa.bean.MoniteurTheorique;
import com.ird.faa.ws.rest.provided.converter.MoniteurTheoriqueConverter;
import com.ird.faa.ws.rest.provided.vo.MoniteurTheoriqueVo;

@Api("Manages moniteurTheorique services")
@RestController
@RequestMapping("api/chercheur/moniteurTheorique")
public class MoniteurTheoriqueRestChercheur {

@Autowired
private MoniteurTheoriqueChercheurService moniteurTheoriqueService;

@Autowired
private MoniteurTheoriqueConverter moniteurTheoriqueConverter;


            @ApiOperation("Updates the specified  moniteurTheorique")
            @PutMapping("/")
            public  MoniteurTheoriqueVo update(@RequestBody  MoniteurTheoriqueVo  moniteurTheoriqueVo){
            MoniteurTheorique moniteurTheorique = moniteurTheoriqueConverter.toItem(moniteurTheoriqueVo);
            moniteurTheorique = moniteurTheoriqueService.update(moniteurTheorique);
            return moniteurTheoriqueConverter.toVo(moniteurTheorique);
            }

    @ApiOperation("Finds a list of all moniteurTheoriques")
    @GetMapping("/")
    public List<MoniteurTheoriqueVo> findAll(){
        return moniteurTheoriqueConverter.toVo(moniteurTheoriqueService.findAll());
    }

    @ApiOperation("Finds a moniteurTheorique with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public MoniteurTheoriqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return moniteurTheoriqueConverter.toVo(moniteurTheoriqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search moniteurTheorique by a specific criteria")
    @PostMapping("/search")
    public List<MoniteurTheoriqueVo> findByCriteria(@RequestBody MoniteurTheoriqueVo moniteurTheoriqueVo){
        return moniteurTheoriqueConverter.toVo(moniteurTheoriqueService.findByCriteria(moniteurTheoriqueVo));
        }

            @ApiOperation("Finds a moniteurTheorique by id")
            @GetMapping("/id/{id}")
            public MoniteurTheoriqueVo findById(@PathVariable Long id){
            return moniteurTheoriqueConverter.toVo(moniteurTheoriqueService.findById(id));
            }

            @ApiOperation("Saves the specified  moniteurTheorique")
            @PostMapping("/")
            public MoniteurTheoriqueVo save(@RequestBody MoniteurTheoriqueVo moniteurTheoriqueVo){
            MoniteurTheorique moniteurTheorique = moniteurTheoriqueConverter.toItem(moniteurTheoriqueVo);
            moniteurTheorique = moniteurTheoriqueService.save(moniteurTheorique);
            return moniteurTheoriqueConverter.toVo(moniteurTheorique);
            }

            @ApiOperation("Delete the specified moniteurTheorique")
            @DeleteMapping("/")
            public int delete(@RequestBody MoniteurTheoriqueVo moniteurTheoriqueVo){
            MoniteurTheorique moniteurTheorique = moniteurTheoriqueConverter.toItem(moniteurTheoriqueVo);
            return moniteurTheoriqueService.delete(moniteurTheorique);
            }

            @ApiOperation("Deletes a moniteurTheorique by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return moniteurTheoriqueService.deleteById(id);
            }
        @ApiOperation("find by gender reference")
        @GetMapping("/gender/reference/{reference}")
        public List<MoniteurTheorique> findByGenderReference(@PathVariable String reference){
        return moniteurTheoriqueService.findByGenderReference(reference);
        }

        @ApiOperation("delete by gender reference")
        @DeleteMapping("/gender/reference/{reference}")
        public int deleteByGenderReference(@PathVariable String reference){
        return moniteurTheoriqueService.deleteByGenderReference(reference);
        }

        @ApiOperation("find by gender id")
        @GetMapping("/gender/id/{id}")
        public List<MoniteurTheorique> findByGenderId(@PathVariable Long id){
        return moniteurTheoriqueService.findByGenderId(id);
        }

        @ApiOperation("delete by gender id")
        @DeleteMapping("/gender/id/{id}")
        public int deleteByGenderId(@PathVariable Long id){
        return moniteurTheoriqueService.deleteByGenderId(id);
        }





            }

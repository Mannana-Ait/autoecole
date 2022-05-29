package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.PlanningItemChercheurService;

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
import com.ird.faa.bean.PlanningItem;
import com.ird.faa.ws.rest.provided.converter.PlanningItemConverter;
import com.ird.faa.ws.rest.provided.vo.PlanningItemVo;

@Api("Manages planningItem services")
@RestController
@RequestMapping("api/chercheur/planningItem")
public class PlanningItemRestChercheur {

@Autowired
private PlanningItemChercheurService planningItemService;

@Autowired
private PlanningItemConverter planningItemConverter;


            @ApiOperation("Updates the specified  planningItem")
            @PutMapping("/")
            public  PlanningItemVo update(@RequestBody  PlanningItemVo  planningItemVo){
            PlanningItem planningItem = planningItemConverter.toItem(planningItemVo);
            planningItem = planningItemService.update(planningItem);
            return planningItemConverter.toVo(planningItem);
            }

    @ApiOperation("Finds a list of all planningItems")
    @GetMapping("/")
    public List<PlanningItemVo> findAll(){
        return planningItemConverter.toVo(planningItemService.findAll());
    }

    @ApiOperation("Finds a planningItem with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PlanningItemVo findByIdWithAssociatedList(@PathVariable Long id){
    return planningItemConverter.toVo(planningItemService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search planningItem by a specific criteria")
    @PostMapping("/search")
    public List<PlanningItemVo> findByCriteria(@RequestBody PlanningItemVo planningItemVo){
        return planningItemConverter.toVo(planningItemService.findByCriteria(planningItemVo));
        }

            @ApiOperation("Finds a planningItem by id")
            @GetMapping("/id/{id}")
            public PlanningItemVo findById(@PathVariable Long id){
            return planningItemConverter.toVo(planningItemService.findById(id));
            }

            @ApiOperation("Saves the specified  planningItem")
            @PostMapping("/")
            public PlanningItemVo save(@RequestBody PlanningItemVo planningItemVo){
            PlanningItem planningItem = planningItemConverter.toItem(planningItemVo);
            planningItem = planningItemService.save(planningItem);
            return planningItemConverter.toVo(planningItem);
            }

            @ApiOperation("Delete the specified planningItem")
            @DeleteMapping("/")
            public int delete(@RequestBody PlanningItemVo planningItemVo){
            PlanningItem planningItem = planningItemConverter.toItem(planningItemVo);
            return planningItemService.delete(planningItem);
            }

            @ApiOperation("Deletes a planningItem by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return planningItemService.deleteById(id);
            }
        @ApiOperation("find by jour reference")
        @GetMapping("/jour/reference/{reference}")
        public List<PlanningItem> findByJourReference(@PathVariable String reference){
        return planningItemService.findByJourReference(reference);
        }

        @ApiOperation("delete by jour reference")
        @DeleteMapping("/jour/reference/{reference}")
        public int deleteByJourReference(@PathVariable String reference){
        return planningItemService.deleteByJourReference(reference);
        }

        @ApiOperation("find by jour id")
        @GetMapping("/jour/id/{id}")
        public List<PlanningItem> findByJourId(@PathVariable Long id){
        return planningItemService.findByJourId(id);
        }

        @ApiOperation("delete by jour id")
        @DeleteMapping("/jour/id/{id}")
        public int deleteByJourId(@PathVariable Long id){
        return planningItemService.deleteByJourId(id);
        }





            }

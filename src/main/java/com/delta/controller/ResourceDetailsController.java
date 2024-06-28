package com.delta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.delta.entity.Resource;
import com.delta.repository.ResourceDetailRepository;
@RestController
public class ResourceDetailsController {
     @Autowired
    private ResourceDetailRepository resourceDetailRepository;

   @PostMapping("/resource")
    public Resource saveResource(@RequestBody Resource resource) {
        return resourceDetailRepository.create(resource);
    }

    @GetMapping("/resource/{mid}")
    public Resource getResource(@PathVariable String id){
      Resource resource = new Resource();
      resource.setmId(id);
   return  resourceDetailRepository.get(resource);
    }
     @DeleteMapping("/delete/{mid}")
    public Resource deleteResourceById(@PathVariable("mid") String mid) {
        return  resourceDetailRepository.delete(mid);
    }

    @PutMapping("/update/{mid}")
    public void updateCustomer(@PathVariable("mid") String mid, @RequestBody Resource resource) {
        resourceDetailRepository.update(resource);
    }
    
}

package com.xinthe.pms.controller;

import com.xinthe.pms.model.Project;
import com.xinthe.pms.service.GenericService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
@Api(tags = "Project API")
public class ProjectController extends GenericController<Project, String> {

    public ProjectController(GenericService<Project, String> service) {
        super(service);
    }
}

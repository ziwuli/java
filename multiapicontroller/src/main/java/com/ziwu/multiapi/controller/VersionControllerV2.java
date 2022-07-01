package com.ziwu.multiapi.controller;

import com.ziwu.multiapi.annotation.ApiVersion;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("v2")
@ApiVersion(version = 2)
@RequestMapping("/{version}")
public class VersionControllerV2 {
    @RequestMapping("/version")
    public String getVersion(@PathVariable String version) {
        return "v2";
    }
}

/*
 * Copyright 2015, Yahoo Inc.
 * Licensed under the Apache License, Version 2.0
 * See LICENSE file in project root for terms.
 */
package example;

import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.SharePermission;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Bean with Map of Enums.
 */
@Entity
@Table(name = "color_shape")
@Include(rootLevel = true)
@SharePermission
public class MapColorShape {
    private long id;
    private Map<Color, Shape> colorShapeMap = new LinkedHashMap<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ElementCollection
    @MapKeyColumn(name = "color")
    @Column(name = "shape")
    public Map<Color, Shape> getColorShapeMap() {
        return colorShapeMap;
    }

    public void setColorShapeMap(Map<Color, Shape> colorShapeMap) {
        this.colorShapeMap = colorShapeMap;
    }
}

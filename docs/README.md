# poly2tri

poly2tri is a 2D constrained Delaunay triangulation library that implements
the [Sweep-line algorithm for constrained Delaunay triangulation](https://www.tandfonline.com/doi/abs/10.1080/13658810701492241?journalCode=tgis20)
described in V. Domiter and and B. Zalik

poly2tri is a contribution to poly2tri.java project: https://github.com/greenm01/poly2tri.java

## Limitations

Since there are no Input validation of the data given for triangulation you need to think about this.

1. Poly2Tri do not support multiple points with exact same Coordinate. (This is an issue when using
   constraints/polygons)
   a. So if you have a cyclic function that generates points make sure you don't add the same Coordinate twice. b. If
   you are given input and aren't sure same point exist twice you need to check for this yourself. Poly2Tri does a
   simple check if first and last point is same when you create a polygon but that is all the input validation.

2. Poly2Tri do not support intersecting constraints(yet)
   a. This means only simple polygons are supported

## How to use

```java
import org.poly2tri.Poly2Tri;
import org.poly2tri.geometry.polygon.Polygon;
import org.poly2tri.geometry.polygon.PolygonPoint;
import org.poly2tri.triangulation.delaunay.DelaunayTriangle;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    // Prepare input data
    Polygon polygon = new Polygon(Arrays.asList(new PolygonPoint(0, 0, 0),
      new PolygonPoint(10, 0, 1),new PolygonPoint(10, 10, 2),new PolygonPoint(0, 10, 3)));
    // Launch tessellation  
    Poly2Tri.triangulate(polygon);
    // Gather triangles
    List<DelaunayTriangle> triangles = polygon.getTriangles();
  }
}
```


#### Declaring project dependency

You can include Poly2Tri in your project thanks to Sonatype repository.

To use the current snapshot add in the pom

```xml
<repository>
  <id>orbisgis-snapshot</id>
  <name>OrbisGIS sonatype snapshot repository</name>
  <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
</repository>
```

and the following dependency

```xml
<dependency>
    <groupId>org.orbisgis</groupId>
    <artifactId>poly2tri</artifactId>   
    <version>0.7.1-SNAPSHOT</version>
</dependency>
```

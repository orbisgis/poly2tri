# poly2tri

poly2tri is a 2D constrained Delaunay triangulation library that implements the [Sweep-line algorithm for constrained Delaunay triangulation](https://www.tandfonline.com/doi/abs/10.1080/13658810701492241?journalCode=tgis20) 
described in V. Domiter and and B. Zalik

poly2tri is a contribution to  poly2tri.java project: https://github.com/greenm01/poly2tri.java



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

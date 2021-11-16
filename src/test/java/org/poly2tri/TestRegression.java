package org.poly2tri;

import org.junit.jupiter.api.Test;
import org.poly2tri.triangulation.TriangulationPoint;
import org.poly2tri.triangulation.delaunay.DelaunayTriangle;
import org.poly2tri.triangulation.sets.PointSet;
import org.poly2tri.triangulation.util.PointGenerator;

import java.util.List;

public class TestRegression {

    @Disabled
    @Test
    public void testPerformance() {
        List<TriangulationPoint> points = PointGenerator.uniformDistribution(100000, 10);
        PointSet pointSet = new PointSet(points);
        for (int i = 0; i < 20; i++) {
            Poly2Tri.triangulate(pointSet);
            List<DelaunayTriangle> triangles = pointSet.getTriangles();
        }
        //assertEquals(199897, triangles.size());
    }

}

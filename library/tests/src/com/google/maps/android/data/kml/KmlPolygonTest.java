package com.google.maps.android.data.kml;

import com.google.android.libraries.maps.model.LatLng;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class KmlPolygonTest extends TestCase {

    KmlPolygon kmlPolygon;

    public void setUp() throws Exception {
        super.setUp();

    }

    public KmlPolygon createRegularPolygon() {
        ArrayList<LatLng> outerCoordinates = new ArrayList<LatLng>();
        outerCoordinates.add(new LatLng(10, 10));
        outerCoordinates.add(new LatLng(20, 20));
        outerCoordinates.add(new LatLng(30, 30));
        outerCoordinates.add(new LatLng(10, 10));
        ArrayList<List<LatLng>> innerCoordinates = new ArrayList<List<LatLng>>();
        ArrayList<LatLng> innerHole = new ArrayList<LatLng>();
        innerHole.add(new LatLng(20, 20));
        innerHole.add(new LatLng(10, 10));
        innerHole.add(new LatLng(20, 20));
        innerCoordinates.add(innerHole);
        return new KmlPolygon(outerCoordinates, innerCoordinates);
    }

    public KmlPolygon createOuterPolygon() {
        ArrayList<LatLng> outerCoordinates = new ArrayList<LatLng>();
        outerCoordinates.add(new LatLng(10, 10));
        outerCoordinates.add(new LatLng(20, 20));
        outerCoordinates.add(new LatLng(30, 30));
        outerCoordinates.add(new LatLng(10, 10));
        return new KmlPolygon(outerCoordinates, null);
    }

    public void testGetType() throws Exception {
        kmlPolygon = createRegularPolygon();
        assertNotNull(kmlPolygon);
        assertNotNull(kmlPolygon.getGeometryType());
        assertEquals("Polygon", kmlPolygon.getGeometryType());
    }

    public void testGetOuterBoundaryCoordinates() throws Exception {
        kmlPolygon = createRegularPolygon();
        assertNotNull(kmlPolygon);
        assertNotNull(kmlPolygon.getOuterBoundaryCoordinates());
        kmlPolygon = createOuterPolygon();
        assertNotNull(kmlPolygon);
        assertNotNull(kmlPolygon.getOuterBoundaryCoordinates());
    }

    public void testGetInnerBoundaryCoordinates() throws Exception {
        kmlPolygon = createRegularPolygon();
        assertNotNull(kmlPolygon);
        assertNotNull(kmlPolygon.getInnerBoundaryCoordinates());
        kmlPolygon = createOuterPolygon();
        assertNotNull(kmlPolygon);
        assertNull(kmlPolygon.getInnerBoundaryCoordinates());
    }

    public void testGetKmlGeometryObject() throws Exception {
        kmlPolygon = createRegularPolygon();
        assertNotNull(kmlPolygon);
        assertNotNull(kmlPolygon.getGeometryObject());
        assertEquals(kmlPolygon.getGeometryObject().size(), 2);
        kmlPolygon = createOuterPolygon();
        assertNotNull(kmlPolygon);
        assertNotNull(kmlPolygon.getGeometryObject());
        assertEquals(kmlPolygon.getGeometryObject().size(), 1);
    }
}
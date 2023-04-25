package org.example;

public enum Distances implements Distance2{
    EUCLIDEAN{
        @Override
        public double distance(double x1, double y1, double x2, double y2) {
            return Math.sqrt( (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) );
        }
    },
    MANHATTAN{
        @Override
        public double distance( double x1, double y1, double x2, double y2 ) {
            return Math.abs( x1 - x2 ) + Math.abs( y1 - y2 );
        }
    };

    @Override
    public double distance(double x1, double y1, double x2, double y2) {
        return 0;
    }

    @Override
    public double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return 0;
    }
}

package com.demo.base.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Database {
    @UtilityClass
    public static class TypeDefinition {

        public final String JSON = "json";
        public final String JSONB = "jsonb";
    }

    @UtilityClass
    public static class ColumnDefinition {
        public final String JSON = "json";
        public final String JSONB = "jsonb";
        public final String TEXT = "text";

    }

    @UtilityClass
    public static class AioiDashboard {
        @UtilityClass
        public static class Schema {
            @UtilityClass
            public static class DashboardSchema {
                public final String NAME = "scm_dashboard";

                @UtilityClass
                public static class Table {
                    @UtilityClass
                    public static class Dashboard {
                        public final String NAME = "dashboard";

                        @UtilityClass
                        public static class Column {
                            public final String ID = "id";
                            public final String NAME = "name";
                            public final String DESCRIPTION = "description";
                            public final String ROLES = "roles";
                            public final String STATUS = "status";

                        }
                    }

                    @UtilityClass
                    public static class Chart {
                        public final String NAME = "chart";

                        @UtilityClass
                        public static class Column {
                            public final String ID = "id";
                            public final String NAME = "name";
                            public final String DESCRIPTION = "description";
                            public static final String SERIAL_DATA = "serial_data";
                            public static final String CHART_PROPERTIES = "chart_properties";
                        }
                    }

                    @UtilityClass
                    public static class Role {
                        public final String NAME = "roles";

                        @UtilityClass
                        public static class Column {
                            public final String ID = "id";
                            public final String NAME = "name";
                            public final String DESCRIPTION = "description";
                            public final String STATUS = "status";

                        }
                    }

                    @UtilityClass
                    public static class DashboardChart {
                        public final String NAME = "dashboard_chart";

                        @UtilityClass
                        public static class Column {
                            public final String CHART_ID = "chart_id";
                            public final String DASHBOARD_ID = "dashboard_id";

                        }
                    }

                    @UtilityClass
                    public static class DashboardRoles {
                        public final String NAME = "dashboard_roles";

                        @UtilityClass
                        public static class Column {
                            public final String ROLE_ID = "role_id";
                            public final String DASHBOARD_ID = "dashboard_id";

                        }
                    }
                    @UtilityClass
                    public static class SerialMetrics {
                        public final String NAME = "serial_metrics";

                        @UtilityClass
                        public static class Column {
                            public final String NAME = "name";
                            public final String METRIC_RESOLUTION = "metrics_resolution";

                        }
                    }
                    @UtilityClass
                    public static class SerialChart {
                        public final String NAME = "serial_chart";

                        @UtilityClass
                        public static class Column {
                            public final String SERIAL_ID = "serial_id";
                            public final String CHART_ID = "chart_id";

                        }
                    }
                }
            }

            @UtilityClass
            public static class MetricsSchema {
                public final String NAME = "scm_metrics";

                @UtilityClass
                public static class Table {
                    @UtilityClass
                    public static class ConfigApi {
                        public final String NAME = "config_api";

                        @UtilityClass
                        public static class Column {
                            public final String ID = "id";
                            public final String NAME = "name";
                            public final String DESCRIPTION = "description";
                            public final String PATH = "path";
                            public final String STATUS = "status";
                            public final String TYPE = "type";
                            public final String PARAMS = "params";
                            public final String INTERVAL = "interval";

                        }
                    }

                    @UtilityClass
                    public static class MetricsData {
                        public final String NAME = "metrics_data";

                        @UtilityClass
                        public static class Column {
                            public final String ID = "id";
                            public final String API_ID = "api_id";
                            public final String TIME = "time";
                            public final String STR_TIME = "str_time";
                            public final String VALUE = "value";
                            public final String SCORE = "score";
                            public final String TYPE = "type";

                        }
                    }

                    @UtilityClass
                    public static class StableCoins {

                        public final String NAME = "stable_coins";

                        @UtilityClass
                        public static class Column {
                            public static final String ID = "id";
                            public final String COIN_ID = "coin_id";
                            public static final String COIN_NAME = "name";
                            public final String SYMBOL = "symbol";
                            public final String PEG_TYPE = "peg_type";
                            public final String PRICE_USD = "price_usd";
                            public final String CURRENT_CIRCULATING = "current_circulating";
                        }

                    }

                    @UtilityClass
                    public static class StableCoinsDetail {

                        public final String NAME = "stable_coins_detail";

                        @UtilityClass
                        public static class Column {
                            public static final String ID = "id";
                            public final String COIN_ID = "coin_id";
                            public final String TIME = "time";
                            public final String PEG_TYPE = "peg_type";
                            public final String CIRCULATING = "circulating";
                            public final String UNRELEASED = "unreleased";
                            public static final String COIN_NAME = "name";
                            public static final String PRICE = "price";
                        }
                    }
                }
            }
        }
    }
}

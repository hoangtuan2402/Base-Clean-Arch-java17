package com.demo.base.constants;

import com.demo.base.constants.enums.DomainType;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class Constants {
    @UtilityClass
    public static class Application {
        public final String CURRENT_PRICE_URL = "https://jg6lu1qbob.execute-api.ap-southeast-1.amazonaws.com/Dev?id=?";
    }
    @UtilityClass
    public static class Glassnode {
        public final List<DomainType> GLASSNODE_DOMAINS = Arrays.asList(DomainType.GLASSNODE, DomainType.GLASSNODE_SCORE);
        @UtilityClass
        public static class Header {
            public final String API_KEY = "X-Api-Key";
        }

        @UtilityClass
        public static class QueryParams {
            public final String ASSETS = "a";
            public final String SINCE = "s";
            public final String UNTIL = "u";
            public final String INTERVAL = "i";
            public final String CURRENCY = "c";
        }
    }

    @UtilityClass
    public static class Defililama {
        public final String BASE_URL = "https://stablecoins.llama.fi";
        public final List<String> IGNORE_STABLE_COIN_LIST = List.of("GYEN", "LCNY", "UAHT", "NARS");
        public final String TOTAL_MARKET_CAP = "4d502398-4af4-4fe8-9fc7-0cc1d4c89234";
        public final String BTC_PRICE_UPDATE = "8366ba03-e836-4206-9171-39090ce6269f";
    }

    @UtilityClass
    public static class Formula {
        public final String GLASSNODE_DAYS = "(GLASSNODE--[a-f0-9\\\\-]{36}--DAYS)";
        public final String GLASSNODE_HOURS = "(GLASSNODE--[a-f0-9\\\\-]{36}--HOURS)";
        public final String GLASSNODE_MINUTE = "(GLASSNODE--[a-f0-9\\\\-]{36}--MINUTE)";
        public final String GLASSNODE_WEEK = "(GLASSNODE--[a-f0-9\\\\-]{36}--WEEK)";
        public final String GLASSNODE_MONTH = "(GLASSNODE--[a-f0-9\\\\-]{36}--MONTH)";
        public final String DEFI_DAYS = "(DEFI--[0-9]+--DAYS)";
        public final List<String> ALL_PATTERN = Arrays.asList(GLASSNODE_DAYS,
                GLASSNODE_HOURS, GLASSNODE_MINUTE,
                GLASSNODE_WEEK, GLASSNODE_MONTH, DEFI_DAYS);
        @UtilityClass
        public static class Structure {
            public final int DOMAIN = 0;
            public final int UUID = 1;
            public final int INTERVAL_TYPE = 2;
            public static final String SPLIT = "--";
        }
    }
}

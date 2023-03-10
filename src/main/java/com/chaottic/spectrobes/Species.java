package com.chaottic.spectrobes;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

import java.util.Map;

public enum Species {
    VILAR,
    VILAMASTA,
    VILANOX,
    SEGU,
    SEGULOS,
    SEGULARA,
    HARUMI,
    HARUMITE,
    HARUMITEY,
    SPIKO,
    SPIKAN,
    SPIKANOR,
    NAGU,
    NAGURYU,
    NAGUZORO,
    INKANA,
    INKANAPA,
    INKAFLARE,
    DONGOR,
    DONGORA,
    DONGIGA,
    BARTOR,
    BARTOLOR,
    BARTOLOSA,
    AOI,
    AOBA,
    AOBASAR,
    KOMAINU,
    KOMANOTO,
    KOMADOROS,
    SHAKIN,
    SHAKOR,
    SHAKOBLAD,
    ZOZA,
    ZOZANE,
    ZOZANERO,
    GRILDA,
    GRILDEN,
    GRILDRAGOS,
    GEJIO,
    GEJIGEN,
    GEJIGAGE,
    KASUMI,
    KASUMITE,
    KASUMIRE,
    SAMUKABU,
    SAMURITE,
    SAMUGEKI,
    KUBAKU,
    KUGANON,
    KUGASTER,
    MASETTO,
    MASEROBO,
    MASETOSU,
    DANAWA,
    DANAPIX,
    DANAPHANT,
    TENKRO,
    SENKRO,
    GEKIKRO,
    MOSSARI,
    MOSSARITO,
    MOSSAX,
    MESA,
    MESABONE,
    MESATHORN,
    WINDORA,
    THUNDORA,
    VILAKROMA,
    WINBA,
    WINBUS,
    THUNBA,
    THUNDOR,
    GAGONG,
    GARGONG,
    ZERAGONG,
    KOROKO,
    KOROGEKI,
    KOROZAMA,
    OJIMARU,
    OJIDONO,
    OJIZAMA,
    TAMAZOA,
    TIAZOA,
    GOKAZOA,
    MUGON,
    CHOMUGON,
    GEKIMUGON,
    SHIMAINU,
    SHIMANOTO,
    SHIMADOROS,
    DARUCHO,
    DARUTORI,
    DARUTAKE,
    BOMA,
    BOMA_BOMA,
    DOMA_BOMA,
    AZAPI,
    AZAMARU,
    AZAMAROS,
    SENPU,
    SENPURA,
    SENPUGA,
    AZEKO,
    AZENOR,
    AZEWANA,
    MANTRADOR,
    MANTRADORA,
    MANTRADOS,
    PAGO,
    PAGONI,
    PAGOYAMA,
    LEO,
    LEOPUBA,
    LEOZAR,
    TOBASU,
    KETOBASU,
    BUTOBASU,
    DENDEN,
    DENDAMA,
    DENPACHI,
    KARAKURI,
    KAMAKURI,
    GEKIKURI,
    HAPACHA,
    HAPAZOA,
    HAPAXIOM,
    ANUBI,
    ANUBOS,
    ANUBEROS,
    RYZA,
    RYGAZELLE,
    RYDRAKE,
    TORGA,
    TORGAZAR,
    TORGALLUP,
    NOKOKO,
    NOKOGIRO,
    NOKOGILLA,
    SHOGYO,
    CHUGYO,
    DAIGYO,
    HANEOTO,
    HANEGAKU,
    HANEBAKUON,
    KIBATEKKA,
    BAKURAIYA,
    ISADORA,
    PIKOS,
    PINSKA,
    PINORSKA,
    MAKANUI,
    MAKANOTO,
    MAKADOROS,
    MUSAKABU,
    MUSARITE,
    MUSAGEKI,
    SAMETTO,
    SAMEROBO,
    SAMETOSU,
    RUDACHO,
    RUDATORI,
    RUDATAKE,
    ZAAPI,
    ZAAMARU,
    ZAAMAROS,
    ELO,
    ELOPUBA,
    ELOZAR,
    PAHACHA,
    PAHAZOA,
    PAHAXION,
    ZRYA,
    ZYRGAZELLE,
    ZYRDRAKE,
    TROGA,
    TROGAZAR,
    TROGALLUP,
    TEKKA,
    TEKKADON,
    TEKKADORAX,
    ZEN,
    GAZEN,
    TOTSUZEN,
    HIKO,
    HIKODRAKE,
    HIKOLOSSA,
    ZAZA,
    ZAZANE,
    ZAZANERO,
    ZENI,
    ZENIGOR,
    ZENIPYRA,
    UKABI,
    UKALOS,
    UKAZEER,
    PAGA,
    PAGANI,
    PAGADORI,
    ZUWA,
    ZUWAJA,
    ZUWAKRID,
    DONGU,
    RAPAGU,
    DAIDONGU,
    PEPE,
    PEPEZA,
    PEPETHRAZ,
    SABO,
    SABOGAR,
    SABOQUILL,
    HANANOMI,
    PIXIMI,
    FLORAMI,
    MAYAR,
    MAYAREX,
    MAYAZERRA,
    GORZ,
    GORGAN,
    GORBERUS,
    ZAPPI,
    ZAPPIRA,
    ZAPPIZOR,
    TOTEMO,
    TOTEMOON,
    TOTEGARDA,
    ZORA,
    BAZORA,
    YAGIZORA
    ;

    public static final BiMap<Namespace, Species> BI_MAP = ImmutableBiMap.ofEntries(
            Map.entry(new Namespace("spectrobes", "vilar"), VILAR),
            Map.entry(new Namespace("spectrobes", "vilamasta"), VILAMASTA),
            Map.entry(new Namespace("spectrobes", "vilanox"), VILANOX),
            Map.entry(new Namespace("spectrobes", "segu"), SEGU),
            Map.entry(new Namespace("spectrobes", "segulos"), SEGULOS),
            Map.entry(new Namespace("spectrobes", "segulara"), SEGULARA),
            Map.entry(new Namespace("spectrobes", "harumi"), HARUMI),
            Map.entry(new Namespace("spectrobes", "harumite"), HARUMITE),
            Map.entry(new Namespace("spectrobes", "harumitey"), HARUMITEY),
            Map.entry(new Namespace("spectrobes", "spiko"), SPIKO),
            Map.entry(new Namespace("spectrobes", "spikan"), SPIKAN),
            Map.entry(new Namespace("spectrobes", "spikanor"), SPIKANOR),
            Map.entry(new Namespace("spectrobes", "nagu"), NAGU),
            Map.entry(new Namespace("spectrobes", "naguryu"), NAGURYU),
            Map.entry(new Namespace("spectrobes", "naguzoro"), NAGUZORO),
            Map.entry(new Namespace("spectrobes", "inkana"), INKANA),
            Map.entry(new Namespace("spectrobes", "inkanapa"), INKANAPA),
            Map.entry(new Namespace("spectrobes", "inkaflare"), INKAFLARE),
            Map.entry(new Namespace("spectrobes", "dongor"), DONGOR),
            Map.entry(new Namespace("spectrobes", "dongora"), DONGORA),
            Map.entry(new Namespace("spectrobes", "dongiga"), DONGIGA),
            Map.entry(new Namespace("spectrobes", "bartor"), BARTOR),
            Map.entry(new Namespace("spectrobes", "bartolor"), BARTOLOR),
            Map.entry(new Namespace("spectrobes", "bartolosa"), BARTOLOSA),
            Map.entry(new Namespace("spectrobes", "aoi"), AOI),
            Map.entry(new Namespace("spectrobes", "aoba"), AOBA),
            Map.entry(new Namespace("spectrobes", "aobasar"), AOBASAR),
            Map.entry(new Namespace("spectrobes", "komainu"), KOMAINU),
            Map.entry(new Namespace("spectrobes", "komanoto"), KOMANOTO),
            Map.entry(new Namespace("spectrobes", "komadoros"), KOMADOROS),
            Map.entry(new Namespace("spectrobes", "shakin"), SHAKIN),
            Map.entry(new Namespace("spectrobes", "shakor"), SHAKOR),
            Map.entry(new Namespace("spectrobes", "shakoblad"), SHAKOBLAD),
            Map.entry(new Namespace("spectrobes", "zoza"), ZOZA),
            Map.entry(new Namespace("spectrobes", "zozane"), ZOZANE),
            Map.entry(new Namespace("spectrobes", "zozanero"), ZOZANERO),
            Map.entry(new Namespace("spectrobes", "grilda"), GRILDA),
            Map.entry(new Namespace("spectrobes", "grilden"), GRILDEN),
            Map.entry(new Namespace("spectrobes", "grildragos"), GRILDRAGOS),
            Map.entry(new Namespace("spectrobes", "gejio"), GEJIO),
            Map.entry(new Namespace("spectrobes", "gejigen"), GEJIGEN),
            Map.entry(new Namespace("spectrobes", "gejigage"), GEJIGAGE),
            Map.entry(new Namespace("spectrobes", "kasumi"), KASUMI),
            Map.entry(new Namespace("spectrobes", "kasumite"), KASUMITE),
            Map.entry(new Namespace("spectrobes", "kasumire"), KASUMIRE),
            Map.entry(new Namespace("spectrobes", "samukabu"), SAMUKABU),
            Map.entry(new Namespace("spectrobes", "samurite"), SAMURITE),
            Map.entry(new Namespace("spectrobes", "samugeki"), SAMUGEKI),
            Map.entry(new Namespace("spectrobes", "kubaku"), KUBAKU),
            Map.entry(new Namespace("spectrobes", "kuganon"), KUGANON),
            Map.entry(new Namespace("spectrobes", "kugaster"), KUGASTER),
            Map.entry(new Namespace("spectrobes", "masetto"), MASETTO),
            Map.entry(new Namespace("spectrobes", "maserobo"), MASEROBO),
            Map.entry(new Namespace("spectrobes", "masetosu"), MASETOSU),
            Map.entry(new Namespace("spectrobes", "danawa"), DANAWA),
            Map.entry(new Namespace("spectrobes", "danapix"), DANAPIX),
            Map.entry(new Namespace("spectrobes", "danaphant"), DANAPHANT),
            Map.entry(new Namespace("spectrobes", "tenkro"), TENKRO),
            Map.entry(new Namespace("spectrobes", "senkro"), SENKRO),
            Map.entry(new Namespace("spectrobes", "gekikro"), GEKIKRO),
            Map.entry(new Namespace("spectrobes", "mossari"), MOSSARI),
            Map.entry(new Namespace("spectrobes", "mossarito"), MOSSARITO),
            Map.entry(new Namespace("spectrobes", "mossax"), MOSSAX),
            Map.entry(new Namespace("spectrobes", "mesa"), MESA),
            Map.entry(new Namespace("spectrobes", "mesabone"), MESABONE),
            Map.entry(new Namespace("spectrobes", "mesathorn"), MESATHORN)
    );
}

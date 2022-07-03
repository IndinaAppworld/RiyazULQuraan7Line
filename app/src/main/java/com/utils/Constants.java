package com.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 8/27/2016.
 */
public class Constants {
    public static String TOASTCOLOR="#6E6E70",TOASTCOLOR_TEXT="#FFFFFF";


    public static SharedPreferences sp;
    public static SharedPreferences.Editor editor;
    public static String prefName="pref1";

    public static int width, height;
    public static String RATE_ID = "com.app.riyazulquran7line";

    static Typeface tf = null, tf_arabic;
    public static int fontSize = 15;
    public static String surehname_arabic[] =
            {
                    "الفاتحة", "البقرة", "اٰل عمران", "النساء", "المائدة", "الانعام", "الاعراف", "الانفال", "التوبة", "يونس", "هود", "يوسف", "الرعد", "ابراهيم", "الحجر", "النحل", "بنی اسرائیل", "الكهف", "مريم", "طه", "الانبياء", "الحج", "المؤمنون", "النور", "الفرقان", "الشعراء", "النمل", "القصص", "العنكبوت", "الروم", "لقمان", "السجدة", "الاحزاب", "سبا", "فاطر", "يٰس", "الصّٰفّٰت", "ص", "الزمر", "المؤمن", "حم السجدہ", "الشورى", "الزخرف", "الدخان", "الجاثية", "الاحقاف", "محمد", "الفتح", "الحجرات", "ق", "الذّٰريٰت", "الطور", "النجم", "القمر", "الرحمن", "الواقعة", "الحديد", "المجادلة", "الحشر", "الممتحنة", "الصف", "الجمعة", "المنافقون", "التغابن ", "الطلاق", "التحريم", "الملك", "القلم", "الحاقّة", "المعارج", "نوح", "الجن", "المزمل", "المدثر", "القيامة", "الدھر", "المرسلٰت", "النبا", "النّٰزعٰت", "عبس", "التكوير", "الانفطار", "المطفّفين", "الانشقاق", "البروج", "الطارق", "الاعلى", "الغاشية", "الفجر", "البلد", "الشمس", "اليل", "الضحى", "الانشراح", "التين", "العلق", "القدر", "البينة", "الزلزلة", "العٰديٰت", "القارعة", "التكاثر", "العصر", "الهمزة", "الفيل", "قريش", "الماعون", "الكوثر", "الكٰفرون", "النصر", "اللھب", "الاخلاص", "الفلق", "الناس",
            };

    public static String surehname_english[] =
            {
                    "Al-Fatiha ", "Al-Baqara ", "Aal-e-Imran ", "An-Nisa ", "Al-Maeda ", "Al-Anaam ", "Al-Araf ", "Al-Anfal ", "At-Taubah ", "Yunus ", "Hud ", "Yusuf ", "Ar-Rad ", "Ibrahim ", "Al-Hijr ", "An-Nahl ", "Bani Israil ", "Al-Kahf ", "Maryam ", "Taha ", "Al-Anbiya ", "Al-Hajj ", "Al-Mumenoon ", "An-Noor ", "Al-Furqan ", "Ash-Shuara ", "An-Naml ", "Al-Qasas ", "Al-Ankaboot ", "Ar-Room ", "Luqman ", "As-Sajda ", "Al-Ahzab ", "Saba ", "Fatir ", "Ya Seen ", "As-Saaffat ", "Sad ", "Az-Zumar ", "Al Momin", "Haa meem sajda", "Ash-Shura ", "Az-Zukhruf ", "Ad-Dukhan ", "Al-Jathiya ", "Al-Ahqaf ", "Muhammad ", "Al-Fath ", "Al-Hujraat ", "Qaf ", "Adh-Dhariyat ", "At-tur ", "An-Najm ", "Al-Qamar ", "Ar-Rahman ", "Al-Waqia ", "Al-Hadid ", "Al-Mujadila ", "Al-Hashr ", "Al-Mumtahana ", "As-Saff ", "Al-Jumua ", "Al-Munafiqoon ", "At-Taghabun ", "At-Talaq ", "At-Tahrim ", "Al-Mulk ", "Al-Qalam ", "Al-Haaqqa ", "Al-Maarij ", "Nooh ", "Al-Jinn ", "Al-Muzzammil ", "Al-Muddathir ", "Al-Qiyama ", "Ad-Dahar ", "Al-Mursalat ", "An-Naba ", "An-Naziat ", "Abasa ", "At-Takwir ", "AL-Infitar ", "Al-Mutaffifin ", "Al-Inshiqaq ", "Al-Burooj ", "At-Tariq ", "Al-Ala ", "Al-Ghashiya ", "Al-Fajr ", "Al-Balad ", "Ash-Shams ", "Al-Lail ", "Ad-Dhuha ", "Al-Inshirah ", "At-Tin ", "Al-Alaq ", "Al-Qadr ", "Al-Bayyina ", "Al-Zalzala ", "Al-Adiyat ", "Al-Qaria ", "At-Takathur ", "Al-Asr ", "Al-Humaza ", "Al-fil ", "Quraish ", "Al-Maun ", "Al-Kauther ", "Al-Kafiroon ", "An-Nasr ", "Al-Lahab ", "Al-Ikhlas ", "Al-Falaq ", "An-Nas ",

            };
    public static String paraname_english[] = {

//		"Alif Lam Meem", "Sayaqool", "Tilkal Rusull", "Lan Tana Loo", "Wal Mohsanat", "La Yuhibbullah", "Wa Iza Samiu", "Wa Lau Annana", "Qalal Malao", "Wa A'lamu", "Yatazeroon", "Wa Mamin Da'abat", "Wa Ma Ubrioo", "Rubama", "Subhanallazi", "Qal Alam", "Aqtarabo", "Qadd Aflaha", "Wa Qalallazina", "A'man Khalaq", "Utlu Ma Oohi", "Wa Manyaqnut", "Wa Mali", "Faman Azlam", "Elahe Yuruddo", "Ha'a Meem", "Qala Fama Khatbukum", "Qadd Sami Allah", "Tabarakallazi", "Amma Yatasa'aloon"
            "Alif Lam Meem", "Sayaqool", "Tilkal Rusull", "Lan Tana Loo", "Wal Mohsanat", "La Yuhibbullah", "Wa Iza Samiu", "Wa Lau Annana", "Qalal Malao", "Wa A'lamu", "Yatazeroon", "Wa Mamin Da'abat", "Wa Ma Ubrioo", "Rubama", "Subhanallazi", "Qal Alam", "Aqtarabo", "Qadd Aflaha", "Wa Qalallazina", "A'man Khalaq", "Utlu Ma Oohi", "Wa Manyaqnut", "Wa Mali", "Faman Azlam", "Elahe Yuruddo", "Ha'a Meem", "Qala Fama Khatbukum", "Qadd Sami Allah", "Tabarakallazi", "Amma ",

    };
    public static String paraname_arabic[] = {

            "الٓمّ", "سَيَقُوْل", "تِلْكَ الرُّسُل", "لَنْ تَنَالُوا", "وَالْمُحْصَنٰت", "لَا يُحِبُّ الله", "وَاِذَا سَمِعُوْا", "وَلَوْ اَنَّنَا", "قَالَ الْمَلَا", "وَاعْلَمُوْا", "يَعْتَذِرُوْن", "وَمَا مِنْ دَابَّة", "وَمَا اُبَرِّیٔ", "رُبَمَا", "سُبْحٰنَ الَّذِي", "قَالَ اَلَم", "اِقْتَرَب", "قَدْ اَفْلَح", "وَقَالَ الَّذِيْن", "اَمَّنْ خَلَق", "اُتْلُ مَا اُوْحِي", "وَمَنْ يَّقْنُت", "وَمَا لِي", "فَمَنْ اَظْلَم", "اِلَيْهِ يُرَدُّ", "حٓمٓ", "قَالَ فَمَا خَطْبُكُم", "قَدْ سَمِعَ الله", "تَبٰرَكَ الَّذِي", "عَمَّ",
//		"الم", "سَيَقُولُ", "تِلْكَ الرُّسُلُ", "لَنْ تَنَالُوا", "وَالْمُحْصَنَاتُ", "لَا يُحِبُّ اللَّهُ", "وَإِذَا سَمِعُوا", "وَلَوْ أَنَّنَا", "قَالَ الْمَلَأُ", "وَاعْلَمُوا", "يَعْتَذِرُونَ", "وَمَا مِنْ دَابَّةٍ", "وَمَا أُبَرِّئُ", "رُبَمَا", "سُبْحَانَ الَّذِي", "قَالَ أَلَمْ", "اقْتَرَبَ", "قَدْ أَفْلَحَ", "وَقَالَ الَّذِينَ", "أَمَّنْ خَلَقَ", "اتْلُ مَا أُوحِيَ", "وَمَنْ يَقْنُتْ", "وَمَا لِيَ", "فَمَنْ أَظْلَمُ", "إِلَيْهِ يُرَدُّ", "حم", "قَالَ فَمَا خَطْبُكُمْ", "قَدْ سَمِعَ اللَّهُ", "تَبَارَكَ الَّذِي", "عَمَّ يَتَسَاءَلُونَ"


    };
//    public static int surehindex[]={2, 3, 107, 166, 231, 281, 333, 394, 416,463,495,529,560,575,590,603,638,666,693,710,734,755,778,797,821,837,862,882,907,925,941,951,958,981,996,1010,1024,1041,1055,1076,1098,1112,1128,1144,1151,1161,1172,1183,1194,1201,1208,1215,1220,1227,1233,1240,1249,1260,1268,1276,1282,1287,1291,1293,1298,1304,1309,1315,1320,1325,1329,1333,1338,1342,1346,1350,1354,1358,1361,1365,1368,1370,1372,1375,1377,1380,1381,1383,1385,1388,1389,1391,1392,1393,1394,1395,1396,1397,1399,1400,1401,1402,1403,1403,1404,1405,1405,1406,1406,1407,1408,1408,1409,1409,1410};
public static int surehindex[]={2,3, 165,258,360,437,517,612,647,719,769,821,869,893,916,936,989,1032,1075,1100,1137,1170,1205,1234,1271,1296,1333,1364,1403,1430,1453,1467,1478,1514,1538,1560,1581,1607,1628,1660,1695,1716,1741,1766,1777,1791,1809,1826,1843,1853,1864,1875,1884,1893,1903,1914,1927,1945,1957,1969,1979,1986,1990,1996,2003,2012,2019,2028 ,2037 ,2044 ,2051,2057,2064,2070,2077,2082,2089,2095,2100,2105 ,2110 ,2113 ,2116 ,2121 ,2124 ,2128, 2130,2132 ,2135 ,2139 ,2142 ,2144 , 2146,2148,2149 ,2150 ,2152 ,2153 ,2156,2157,2159, 2160,2161 ,2162, 2163,2164 ,2165 ,2166,2166,2167,2168,2168,2169,2170 };
    public static int paraIndex[]={2,71,139,207,275,345,415,487,557,629,699, 771,845 ,917 ,989 ,1063 ,1137 ,1205 ,1279 ,1353 ,1421,1493, 1565,1643 ,1713 ,1791, 1869, 1945, 2019,2095 };



    public static void setFont_cipher(TextView t,Context context)
    {
        if(tf==null)
            tf= Typeface.createFromAsset(context.getAssets(),"Helvetica.otf");
        t.setTypeface(tf,Typeface.BOLD);
    }
    public  static String readRawTextFile(Context ctx, int resId) {
        InputStream inputStream = ctx.getResources().openRawResource(resId);

        InputStreamReader inputreader;
        try {
            inputreader = new InputStreamReader(inputStream, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            return null;
        }
        BufferedReader buffreader = new BufferedReader(inputreader);
        String line;
        StringBuilder text = new StringBuilder();

        try {
            while ((line = buffreader.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
        } catch (IOException e) {
            return null;
        }
        return text.toString();
    }
public static void startWebStiteAct(Context context)
{
//    Intent intent=new Intent(Intent.ACTION_VIEW);
//    intent.setData(Uri.parse("http://wwww.google.com"));
//    context.startActivity(intent);





}
    public static void startShareAct(Context context)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(android.content.Intent.EXTRA_TEXT, Constants.share_data);
                    context.startActivity(intent);
    }
    public static void startRateUsAct(Context context)
    {
        try {
                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + Constants.RATE_ID)));
        } catch (android.content.ActivityNotFoundException anfe) {
                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?"+Constants.RATE_ID)));
                    }
    }

    public static String share_data="Good News\n\n" +
            "Android application of Riyaz-ul-Quran (Urdu Translation of Holy Quran by Hazrat Maulana Muhammad Yunus Sahab Palanpuri DB) is available at Google play store." +
            "In which the Quranic texts and translations are written in a large font size, so that the persons with weak eye vision can also easily read it. \n\n" +
            "Furthermore, Every Surah is beautified with Bismillah written in different calligraphic styles. \n\n" +
            "Download 7 line Riyaz-ul-Quran Android app from the link below.\n https://play.google.com/store/apps/details?id=com.app.riyazulquran7line\n\n" +
            "Share this message as much as possible. You will get the reward for people downloading and reading the Quran Insha Allah.\n";


    public static int EXIT_APP=1;
    public static int HOME=2;

    public static int LANGUAGE_ID=0;//0 =Urdu 1= English
    public static int ENGLISH=0,URDU=1;
    public static String FAZILT_TEXT="Fazail-e-Quran",MUTTARIFAQ="Mutafarriqaat";

    public static String urdu_array[]={

            "زبان منتخب کریں",
            "دوبارہ شروع/نشاندہی",
            "پاروں کی فہرست",
            "سورتوں کی فہرست",
            "صفحہ پر جائیں",
//	"نشاندہی ",
            "دوبارہ شروع/نشاندہی",
            "مدد اور درخواست",
            "قرآن کریم",
            "کیا آپ کا وضو ہے ؟  کیا آپ با وضو ہے ؟",
            "ہاں نہیں",
            "خالی نشاندہی",
            "کوئی نشاندہی نہیں ہے، اگر آپ پڑھنے کے درمیان نشان رکھنا چاہتےہے تو آوازکے کم زیادہ کرنے والی بٹن یا مینو بٹن کو استعمال کریں۔",
            "عنوان",
            "محفوظ کریں، منسوخ ",
            "صفحہ نمبر",
            "آخری مرتبہ پڑھاہوا",
            "آگےبڑھے ، منسوخ کریں",
            "سیٹینگ (ترتیب)",
            "برائے کرم کسی ایک کا انتخاب کریں",
            "یاد داشت شامل کریں",
            "پڑھنے کا انداز تبدیل کریں",
            "منسوخ کریں",
            "پڑھنے کا انداز تبدیل کریں",
            "ہمارے دیگر اپلیکیشن",
            "ویب سائٹ ملاحظہ کریں",
            "دوسروں کو بهیجیں",
            "ہمیں سراہیں",
            "باہر نکلیں",
            "مینو  سکری",
            "درست صفحے کے نمبر درج",
            "لاگو",
            "صفحہ نمبر درج کریں",
            "کیا آّپ کا وضو ہے",
            "ہاں" ,
            "نہیں",
            "کیا آپ واقعی بک مارکس سے اس اندراج حذف کرنا چاہتے ہیں ؟",
            "تصدیقی خارج کر دیں",
            "آپ نل طرف سے ایک موجودہ بک مارک اندراج خارج کر دیں اور آپ حذف کرنا چاہتے بک مارک پر پکڑ کر سکتے ہو",

    };
    public static int TOTAL_PAGES=2206;
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

}
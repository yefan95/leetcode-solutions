package de.yefan.leetcode.string;

import java.util.*;

/**
 * Palindrome Pairs
 * https://leetcode-cn.com/problems/palindrome-pairs/description/
 */
public class Num336 {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap();
        if (words == null || words.length <= 0) {
            return res;
        }
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        List<Integer> list;
        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            for (int i = 0; i <= word.length(); i++) {
                String str1 = word.substring(0, i);
                String str2 = word.substring(i);
                if (isPalindrome(str1)) {
                    String str2rev = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rev) && map.get(str2rev) != j) {
                        list = new LinkedList<>();
                        list.add(map.get(str2rev));
                        list.add(j);
                        res.add(list);
                    }
                }
                if (isPalindrome(str2)) {
                    String str1rev = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1rev) && map.get(str1rev) != j && str2.length() != 0) {
                        list = new ArrayList<>();
                        list.add(j);
                        list.add(map.get(str1rev));
                        res.add(list);
                    }
                }
            }
        }

        return res;
    }

    /**
     * 暴力法(超时)
     *
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs1(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        if (words == null || words.length <= 0) {
            return res;
        }
        List<Integer> list;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (i != j) {
                    if (isPalindrome(words[i] + words[j])) {
                        list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        res.add(list);
                    }
                }
            }
        }

        return res;
    }

    private boolean isPalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        Num336 num336 = new Num336();
        String[] words = {"bchcfehaiaajbibjeh",
                "b", "abfcgcgechbci", "eiefcgaedcg", "iccci", "diaijheecaied", "idgc", "iighhebjia", "f", "fbhgggfgj", "daddiidfahi", "fbafdbfcjbgifbeg", "hag", "iaedbjfhff", "agigcfajfgbijc", "ea", "idacbjda", "ffgcbhgaghgcfj", "hcagid", "ajdadjefejbeh", "bdbgjd", "dhdcjghahc", "djacchdgebcgehjfgjfj", "ggaaicg", "gj", "cbdcgfbijdihjgj", "aghaicgchaiij", "idajacfbabhigaa", "jdgechbggeddjdc", "jjdjdihhdjfafff", "jghfhi", "aih", "bf", "digdgfhfdgjjgdc", "baf", "daiadgeagjbibih", "cidjbdgjafibbejbbic", "caaecgbecegdfiegbeii", "icchgffd", "jbcjajadgjcgaiabjgfd", "fcebbgahjieiicegaicc", "gdeg", "gehfchfebbdegaahifeg", "cfbaibeiicd", "idjdbahdagjiiaeff", "ghjca", "dfgabheifhffa", "ecfeefiicihg", "bjfjaefffdgaaefaaebh", "cjf", "gdbgce", "cdihdcdadechhejbhidg", "dfhgdgjfjeigfgca", "idcjhgicihebabbjj", "fbegafiha", "jaadeede", "ffefjjdfdccfgicgiih", "jfcaibgf", "g", "jjacejd", "ib", "ifiejbcfgjcefbajif", "ehbgcghhaicj", "bejd", "ifeagedcegefbhb", "ccjcbbjdeb", "fabaee", "aighgdffcch", "bjchjgfbh", "gfjgeeeehafgj", "egcafchgbg", "hfabbaabjghfeagadh", "cacejai", "fjieabfdhjjjccge", "diaeafjjcheb", "dd", "fbfhggbbjhgcdbeab", "gffhaahg", "feicdb", "gejbfhjfchhefcie", "ahdbcb", "jie", "eadagjbfhgf", "dajcdigeaia", "ifiba", "ihhhgj", "fafdbfbaefffhaccajh", "hicdecgbaacefch", "efdddjacacc", "dcaddfcejiahfdjieea", "ebcceejcbjfa", "cgij", "gihhjjbeidadcggbddc", "ififggggbgfghidd", "jefiecejjhjf", "gdc", "fjaifddeihdeeahae", "dhbdbfhgjjcc", "jidihhafbgcd", "bjhhgdbijhjgacebid", "cgjbedadajicjedfg", "jae", "hjjeaghfjg", "gjhggaigcdj", "eehbadeieigicg", "dgffcfg", "daefgh", "def", "ji", "jecgijhcdjhgbjgjdejd", "ebgbcigah", "jhije", "hjadadgffac", "dbajjfigfhigcaebheba", "hjgi", "fchbidbbfb", "hgbeigfdid", "ffbfebhbdhjidcb", "cgfdgdaffbgchgc", "acbg", "gaifbgjhbcjhcfij", "bafbh", "bagd", "cibbihhbdaghdhfajcf", "e", "cfgafaich", "cifgddbibbd", "jhadg", "jcbjefjc", "ehahcbhfdiecjeja", "gehgbfjbccg", "jbibjcfdh", "baiafgdfejjhd", "idicfjaiaiabbiacfjgh", "efccfgcg", "ia", "fgdad", "dijcfddaafehffbgf", "ahibgaaeebh", "diefidijhbhbiagg", "ejedbicfifcg", "fe", "ajacebfjgaddedhaaf", "fdbjiccbfaaej", "dhgg", "egdidaeai", "adhgiihdedicjfdehaia", "cciehcgb", "d", "agdgieidbhgeeghieed", "aa", "daiajfdediagii", "gidcacdfchdhfffjfbb", "ciiefdjddjdfjfaj", "ahjicijeidaghbabdci", "ecdjhaefa", "dbcfdicjaja", "cgchfjbecgaica", "hfehgag", "jiebba", "hdjfcbcjfejfdf", "a", "ejjacigaciabe", "fhadidbdbcgcbjdfff", "cefabgabgcbcdcghab", "iijjdcfccegfbffijhjj", "gicc", "acdgabefiacagfjj", "jeagjdgbhjcjichcfia", "efg", "baheidjhiigd", "fgfbfjfdcegahjigehi", "ciijbadgiab", "jiejfdjgfgeddighja", "ageadfhbhbdagdj", "icigbfcedaifa", "jedgd", "ibefh", "aihdf", "h", "jjceedjbedeefhcj", "jidecahidhbfagfdi", "jfbbdaddjicaefb", "fijadafecah", "hhiaecchcfjfbdchahb", "eaeifbbgbifhfajc", "bacdccccafdiac", "dhce", "ghgaciaijaaggf", "hgjfaagbebfefaed", "c", "cggdahhgcdbiiabeja", "ae", "dfdghfghefggie", "cijbbibahhjgjgggejcd", "cabddde", "egfiha", "bjjgdffedifadgdeh", "ifiiiaj", "dbbecjbcb", "bgheihchffg", "ecffhfaaggegiaj", "bjajhfjjajd", "dhhgiach", "dhieagagfhgbcjhdd", "cjabdc", "iiihihhdaghcd", "bceeffjagchfacdecge", "igicgggajjeeeii", "ieiighhjjjbdgb", "iacaaggibagcig", "bhgggcfhd", "gbiecffeccfchegea", "gcbjf", "fjdffjedcaifdffhaa", "djajf", "fgbgja", "aaid", "aiidahjaj", "ddfiehbbbba", "hafche", "icaagch", "cifjec", "dhchghf", "bhdegahijbgjafgb", "bihjciibgj", "eiej", "aeijdga", "eejcgjhjajfaeaj", "jjbiageg", "ejabjfhghfcja", "hdjjhe", "eabbbbcbcfedecaeb", "jh", "jjbdhicigaciagg", "gigjfgbj", "diaffbf", "fhfaaijbjdceeaajd", "ghagji", "ighefbhjiijedff", "fhd", "eagcgdgig", "edjbdjdbfe", "eeffbjjchj", "dagccfgcjgjigcaid", "ibdafbedhdj", "cefjejjedjdbcaejabd", "bb", "hiiiiebeaejbfiica", "bbcea", "ab", "aaccbhbjghgeef", "iddbdddghfbdcdhifj", "igjbabddgeddcjjafaa", "adecbadddj", "dcbfffjjdaigibig", "iichgcajdbiiie", "ebdjdjiejeegi", "hbabhdiihgchhbjj", "jdggdejegebbahdf", "ai", "hcgjeeggadeccca", "bfdjaceiegbcjfjc", "ihcacegbdcc", "bafi", "ihbgcjaaggefbjdjd", "ciihadhbagihbafcb", "habfhagdfbjh", "hgdggccecfgjgigb", "eigebefahdfdihf", "bhg", "fajfabdedabe", "abedcjhb", "iicjadf", "aihcfbdefhhaiegaccie", "ehajc", "gfediahah", "behjcaafccggecgiic", "babffia", "afdhdcbiffa", "icfcfj", "hcbffghiaaa", "acefbfggg", "hg", "fbihacadeadibh", "ihjfgcgjjigcd", "beffiihhceddgbhgjcg", "hhdcdfhaehidbghajbdh", "debgeejbh", "ahcbh", "cagefihe", "jfggbhbhcebibiahea", "febagdhgiefbfbec", "ddcifhhbjachafgeeg", "jaadijbiebfdbeibeje", "fgjhdabghjce", "fhicfg", "jfdcbhachhg", "acfejfggi", "cj", "hfjbbb", "hgggjggff", "jefeffcffddiic", "cedaefighhfggjghjgdb", "bihhhc", "ieacgjjbgjifca", "aaibfbhgeicca", "acifbfgaihii", "baddafg", "fhajfec", "ihffbhddajcce", "jhefcdiiheghgcj", "degjcgah", "dde", "jaabfdjhadaif", "gba", "hfebaaib", "fgecefcghdh", "jjgi", "hdfchjgdjbcjfehc", "fhfeaeig", "fgdcibbjafdaf", "agchicajgjdgaibadfb", "gfehbf", "ichcbebhgjcghhihi", "bigciceiad", "ebdiejehiabbgcc", "jedjjfdhcicf", "geijjbjjdiifcc", "hhceddceghjgfebfbf", "gffjbbcgfaefcgcge", "jigbb", "je", "aaicdjcfjbh", "jdidcgde", "dhbdjcbfgjaagabb", "bacfjcbiec", "fceihggahacffbhf", "jgjdjg", "hgccfdbbjdjbfjecfdia", "bfhhbjfijdhaicih", "bjjdjjjhebhfgjeagef", "caji", "daaidgjedfcj", "efdhf", "eaihabgcahafaabg", "jfhebfjghaabhfjhcahh", "ag", "ajfbacfbdbedii", "fjgijffhcjffj", "dea", "ddahaiage", "iicdjabigggjhe", "ieghaihjibj", "bdj", "cbidbcehdg", "aibiihfeg", "ee", "jgi", "bdcjabeccjgheb", "hhbj", "fafdfhajjjeabcfcgdie", "hhehja", "agdcfdfjh", "fafa", "afghddadcfbjbcifgh", "jibj", "bbacfg", "bbadffaee", "dicjhbidi", "gh", "jbajigbfeagheegjdaa", "aicbedbah", "dcfdjiaeccgbajfjgea", "iaahhcchbgfgejjhfehc", "cecdgjfjedfjhcc", "faehaibidhcebcfcb", "hd", "hddeegbccdadbjfjb", "bdjadjifj", "aacaehbacieij", "acigdbgbh", "cjjjjhjcfi", "gfbihbdfe", "gijcficfi", "fhefedgchhhfdcgcjie", "igbbcddfjadahajdjc", "bceagahcfdghjj", "jdcja", "abbd", "hhadcbihcae", "abdhib", "dbaidecejchbih", "fbaccdajcbfij", "fdcdjaddafbgj", "dcci", "i", "aheecai", "egcghfjb", "ggedfbg", "ecjeafhffcfjjfcc", "gijggfediachjegbjdfe", "bjdbccagchgcbcec", "iejddfcfdihg", "abcfhdfadijaecihgih", "abebjchchjjbbe", "bdehgfif", "cjeijfacee", "hbaadeicacccb", "gfdbjgaghj", "igehbcchj", "jjia", "caebafdgbcgcfg", "ibdafihhej", "eedeicegjeddaacgecd", "aagbfhhfbhhbejjbjajf", "bchdgcgjihaaidg", "ciccadeg", "gjhidcjdcffhfcef", "bdcahhggeb", "jffciecfjbjcebf", "gbabjiajgcjhfehd", "jdajfbicjggigbj", "ebfga", "jeejacgj", "ibceidcedgghf", "hiabbbijejhcigjjfi", "dgaehccicahfcgic", "bfaejg", "daejhfgiegafciihaj", "jgfcfeeeaeigfadhh", "fjejdficgcbhhifbg", "jhaiagdiffbadccf", "ehbaihbhfccfd", "hhehjdffbijcgedb", "biiij", "fbbbhebjfjjgddfffege", "jdijj", "ibfgebajj", "cgadacabfhhhdacfj", "hahgcjafiagajifje", "if", "abg", "bjfjfhbbc", "dcijidcajicbedeade", "dejbdchchgdecji", "hfafjfi", "edjbbadfaghffc", "eibdbebgdegcggggih", "hcbgaechgdcgdbiegiaf", "eeficfhhagbebjchbhff", "edjcbjjbd", "hihehfbaaabjgbc", "beac", "jcadhajfedgabhjfchaa", "bhff", "djjhcfcjiecjhbef", "iddgjfh", "fcejjfcajicj", "fheigahegeaghifgf", "agdcejc", "dad", "cdecjhabajcchebci", "jjcjji", "gbghghfcfdjefiiaici", "hhdhdfcgcae", "ecibiajjceeecgacc", "heehfijaaf", "cecjhbfhgc", "gahheficaedicfhiicg", "beefejaeabhaddbid", "ah", "chdcjdhg", "eecjdhjhfibaifcc", "aiei", "dbegchjcecba", "bbchffaj", "j", "habidjegh", "icffghbeghdgecfi", "ei", "bfbj", "egfccfdiihhibhgieff", "fbajjgagihgbhegjbj", "haijdgbcfgaaabefccd", "ahib", "ebfhebcidhae", "gfchjebhbifcagdheha", "eggdddaijjhfeeibfid", "jij", "edb", "eeac", "iehifcefib", "bhcfihhecjffg", "ejfjjfif", "iccjjfgjggb", "fcjebbijafj", "hgbdjcdgciea", "cgafdghfacf", "dijbjidibdda", "bcehicegfajbfj", "ifcicchegbihe", "ffhhg", "aeehjfchhehaceaheded", "ahgi", "dcbafhcacfachdg", "ihgaigaaae", "hgicchcegjibb", "egcechhiah", "ggibfefibjbiha", "gf", "hefje", "ehcffcecfeifdgfbf", "bebeadfecdchheiegj", "jfaiggjgb", "ehhjif", "ddca", "edjcgbdhhjheiahi", "gghhbheeee", "fdjec", "ja", "cbgbfbdfdg", "dhhhbchchcdif", "ciajfggefjhifbcb", "iedgj", "hihchciicgibdbbihbec", "jccgiijbcc", "idifj", "iijf", "hfhibfadhcjf", "ihgjhgieiijgecaaag", "cdbachf", "bbfhaibabgiadfgdhi", "fgciifcheihh", "adajhhaa", "gaiegfdafgbcif", "ebbicfifdhgjf", "idbeigaibcdjih", "hiddfcbcb", "cjibcebebdacfa", "fihjiecihfjbbhdfig", "djedejgcgagbcgjib", "bab", "bdcecjdejdhegffi", "gedd", "fjddjbhhjj", "ifgfcjcfcai", "ahh", "ifbhfhdejjejadadh", "cd", "ddhibh", "hcgibciicfa", "jefdjja", "geegghfbbfcaeifff", "giijcdh", "dei", "jjjiiejfdjfhcb", "ebeefidgjhedeeddjg", "behhhgfchicdddhfebic", "hgdeiahjebee", "ibbhieaiihaib", "jiagegca", "edejecjhc", "iehc", "bgjbdfafadeihgegb", "jjbejad", "iga", "ggfcfjf", "badad", "hbaiidffje", "fhdebfggeeadejadjaif", "gbfjfegefaijbd", "bihigjghi", "bifeabifgfbif", "ifh", "hjeceefhje", "ddbcihgj", "edcifi", "cfaacaddhaf", "egj", "debccccaf", "ciiefhdjfdiei", "ccfjdhbghicdac", "hfbbhcjciei", "geghaegdhj", "igcbdehegebj", "jddhjeaj", "ibffhiaa", "hbdijhbfcbfg", "ecjbeijgbdfaj", "fcddchgibadaghgdfe", "cedach", "gjeea", "idffiafigdbhaa", "edccj", "ihgiahca", "gicieaeche", "jjgiiigbchbiie", "ccicf", "ibbbc", "ead", "egeedc", "ajjjhajjbhb", "chjj", "acdbjfhdcdbfggjdab", "ehjdbhicgajfgafagbc", "da", "faaegbi", "gdbbeajjiejdhijef", "ggdbbhjjaibf", "ffej", "effgebjeejadecij", "df", "jefgcdie", "hicecceichiibb", "cej", "jfafgihdiafce", "jjdbihcibii", "agiigbgfdbejdd", "iedaajbdcciigfdc", "fecjccidgafbjbddff", "dhfejdeccihb", "cgffagcafceib", "ihifihf", "jdibafaejdjb", "jeigdgeei", "iehdehhccfchbbhgcejj", "effbhfihac", "iiafgada", "ebdgeggigcfgbiabg", "ehbidfji", "jcbjid", "cihfecddbabgjj", "jdgidjeiegfjhh", "ghfgbcghbidhjgegfa", "jdbefebhjefgbbdih", "aacahh", "fjci", "cebcddiihbeg", "bfajdgahdifbdbfchidc", "iafjjejehhdghidjfbb", "feaaicecedefcdjff", "ihf", "ibhebfighfjbbbcge", "cjhaddgdhidbgefdege", "bbcgdgabddjhc", "jbeabgcffcei", "eg", "didaafcdehgbba", "biifijf", "ajecbaefgdhff", "efagdcecdijefej", "ejecjfcdafa", "ifjjigbicacbajbh", "bhbiigbicedjai", "ghcjjgfc", "gfdcaceaeabjbgi", "djibiccadahaeichfe", "jjjeebdgbaaigfebe", "aibadijjefjhechd", "afjiddaidibhbjaf", "gaiijeffjjbbhjehe", "cec", "fagd", "bidga", "eiahehbdebcibfcj", "ajgbcecfgfbacbdd", "cdih", "cdei", "abe", "dfechhhgiiibj", "biijaeehjei", "ecaiadjgadbcbijidfi", "aibjgaachiadge", "eccgbbadddfidifgbaa", "dicbbjiedeiafehebgih", "edeaeihjib", "gddiac", "aeadjiecia", "abjehchdbbddjgichjib", "gbbbg", "hbbcfcfdhjide", "jdfiiefjjjhgaifebd", "jabbffeag", "bagihjaecifgbdfgjf", "hiac", "fcjafjdiagfce", "difjbedficc", "ggijgegagcijjdh", "ihihg", "echjbjdaejjbdi", "afhijjd", "idigc", "gehfgbg", "agghaggbfdega", "dhiddchjbdgccdiicb", "ifcc", "jfjd", "fdagciafieidibjbd", "jifbjdhcdgbchhc", "bba", "cfiffifbiaiic", "ced", "cbeeahdhfefebeicbbh", "ebaifidc", "ghach", "ccedjfeefieaahcihc", "hfhbgiicijffj", "ijchegejhgcgcfc", "gfbagghgejdijgge", "hfghjffee", "acicfjifjj", "ehfca", "fhabgddc", "heifhfgahfefjbccafaj", "ebfaibii", "aghggjgbdejigbgjfga", "gjaj", "gficdc", "ififeajgicgdgi", "iaiaigihhi", "ejdbdacaccbaaghidi", "ijigefdjaaeaijhbga", "dgdgcfciaghi", "ddgcaba", "fa",
                "bhfgifghc", "bfc", "jfdjaabc", "ecihfdaajjcd"};
        List<List<Integer>> res = num336.palindromePairs(words);
        System.out.println(Arrays.toString(res.toArray()));
    }
}

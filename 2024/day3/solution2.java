import java.util.ArrayList;

public class solution2 {
    public static void main(String[] args) {

        ArrayList<Integer> left = new ArrayList<Integer>(getExtractedData("left"));
        ArrayList<Integer> right = new ArrayList<Integer>(getExtractedData("right"));

        int result = 0;
        for (int i = 0; i < left.size(); i++) {
            result += left.get(i) * right.get(i);
        }

        System.out.println(result);

    }

    public static ArrayList<Integer> getExtractedData(String type) {
        String data = getData() + "abcdeghijklm";

        ArrayList<Integer> left_data = new ArrayList<Integer>();
        ArrayList<Integer> right_data = new ArrayList<Integer>();

        ArrayList<Character> better_data = new ArrayList<Character>();

        int state = 0; // 0--> normal 1-->bracket incoming 2-->inside bracket
        boolean validity = true;
        ;
        boolean starting_bracket = false;
        // boolean left=false,right=false;
        boolean comma = false;
        int temp_left = 0, temp_right = 0;
        boolean enabled = true;
        for (int i = 0; i < data.length() - 12; i++) {
            if (data.substring(i, i + 4).equals("do()")) {
                enabled = true;
            }
            if (data.substring(i, i + 7).equals("don't()")) {
                enabled = false;
            }
            if (data.substring(i, i + 4).equals("mul(") && enabled) {
                state = 1;
                validity = true;
                starting_bracket = false;

                comma = false;
                temp_left = 0;
                temp_right = 0;
            }
            if (state == 1 && enabled) {

                if (!((data.charAt(i) == 'm') ||
                        (data.charAt(i) == 'u') ||
                        (data.charAt(i) == 'l') ||
                        (data.charAt(i) == '('))) {

                    validity = false;
                }
                if (data.charAt(i) == '(' && validity) {

                    state = 2;
                }
            }
            if (state == 2 && enabled) {
                if (Character.isDigit(data.charAt(i)) || data.charAt(i) == '(' || data.charAt(i) == ')'
                        || data.charAt(i) == ',') {
                    better_data.add(data.charAt(i));

                    if (data.charAt(i) == '(') {
                        if (starting_bracket) {
                            validity = false;

                        } else {
                            starting_bracket = true;
                        }
                    }

                    if (data.charAt(i) == ')') {
                        if (comma) {
                            left_data.add(temp_left);
                            right_data.add(temp_right);

                            validity = false;
                        } else {

                        }
                    }

                    if (data.charAt(i) == ',' && !comma) {

                        comma = true;

                    } else if (data.charAt(i) == ',' && comma) {
                        validity = false;
                    }

                    if (!comma && Character.isDigit(data.charAt(i))) {
                        temp_left = temp_left * 10 + Integer.parseInt(String.valueOf(data.charAt(i)));
                    }
                    if (comma && Character.isDigit(data.charAt(i))) {
                        temp_right = temp_right * 10 + Integer.parseInt(String.valueOf(data.charAt(i)));
                    }
                } else {

                    validity = false;
                }
            }
            if (!validity && state != 0) {
                state = 0;
                validity = true;
            }
        }

        if (type == "left") {
            return left_data;
        }
        return right_data;
    }

    public static String getData() {

        return "how(){%}mul(764,432)/mul(464,877)<]/(@!%+(mul(442,248)(where(){mul(413,237)where()'@,^{what()mul(658,740)mul(776,693)$from()why()~mul(37,549)%&:mul(324,662)(}#,)< how(735,819)](mul(385,637)*}where()~)$^:?+mul(977,582)';-/*,who(){mul(830,993)>!mul(936,747)+*mul(332,184)%[,'}mul(46,855),who()from()@+>from()* }mul(419,712)!)how()}+(}/ ^mul(919,234)]]'>mul(504,468)'mul(422,532)>who() ~^why()mul(217,331)select()?:~*}mul(225,876)}who()]^mul(708,740)-mul(676,750)(})when()]how()what()where()!mul(382,991)$-*?^#(mul(99,839)%who()when()&(<)+mul(268,148)when()who()where();do()mul(127,487)select()@>mul(885,259)select()mul(350,499)select()]mul(195,950)how()where()[what()>$mul(650,33)('(!/:~]?when()mul(424,696))[)when()how()]~how()&#mul(390,972)&from()how(598,362)#select()select()mul(427,851)mul(949,353)when()mul(573,903)why()']?when()mul(68,654))#^/where()![]mul(511,431)what()<-(]mul(92,597)>;+why(702,948) mul(429,869)#select()from())>,{mul(591,611),'*) /mul(937,13))<mul(426,779)*!]select() ^* {mul(467,229)what()>><:mul(124,908)select(406,133)&#mul(306,205),&(who()>mul(122,886)%<   {select()mul(256,104)$(how(),(^#from()@mul(896,439)!(&!##)[mul(170,621)why()from()(don't()*>>};why()mul(894,224)!&where()&}how()/)where()mul(45,794)?;>(?what():when()mul(508,731):&'when()/{{mul(631,369)-'why()&mul(686,265)why()~[who()')';]~mul(743,347);<]&'mul(135,902)(mul(537,808)-% ::select()don't()mul(870,738)mul(638,908)select():/%+(,'mul(559,730)><'}?,where()~[why()mul(543,233)what()/where()]%(}]when()$mul(799,224) select()what()mul(326,153)>-why()mul(666,338)from()&-[{^from()mul(165,352)(mul(472,860)}>^(>!who() **mul(172,850)),/mul(446,398)?select()mul(65,759)how()?!mul(878,291)how()mul(876,893)mul(140,704))!from(599,116)mul(869,315)$mul(678,599);%?, when()mul(932,748)/@mul(386,747)]!*why(){&;>(mul(963who()(!don't(){ select()$mul}>/&>$&when()mul(818,939)^)&,'mul(921,168)(?how()#don't()select()#where()why()why()]?)-&mul(638,516)what()<?*}![<:who()mul(298,881){:when()mul(377,193)why()[when())select()[}mul(413,790)mul(290,650)/%!>?from()when()how() -mul(184,516)+(:{when()mul(648,933)[mul(366,695)how()from()mul(652,578),%> $^&{mul(813,742)}/where()< mul(220,395)how()how()mul(252,213#+[*>/!#mul(306,791)(from()don't(){$+<~$mul(425%@>$~*where()mul(411,867)+~&mul(951,759)-~>['mul(712,348)how()%?}:([mul~+mul(271,919)from()*#]@#why()mul(716,99)mul]~@mul(432,702)#/who()%)mul(231,863))[^how()do()[how())select()why(629,173)mul(793,210)'don't()>&what()what(597,711)how()(what()mul(707,5)@*),@&from(),[from()mul(253,394){mul(364,663) /how()^mul(932,681)}mulwhat()#who()#-)>]?@mul(103,187)#*(mul[**why()mul(854,247)mul(210,680)^mul(132,872)when()mul(751,243)mul(956,861)!^~?^$*~:;mul(145,716)(,[#:{who()~mul(695,434)^^/{?how()mul(570,627)when()}},~when()from()%select();mul(153,887)'mul(636,279)!)&when()>{,!*^mul(734,297)/%mul(294,388)(@[mul(616,771)%+select()#;mul(840,851))/>mul(842,820)>mul(911,662)mul(129,906)(&;';mul(827,375)?where()why(){who()'#mul(604,456);##,mul(917,4)^/@why()mul(991,864)\r\n"
                + //
                "mul(268,523)?from()what()where()what(626,270)when()(;who()/mul(529,582)%what()why()[}:]{who()mul(502,968)^mul(660,428) who()[(who()mul(420,265)mul(699]*who()/[how()>what()'mul(335,526)mul(668,634);#*(+how(968,582)^#mul(247,669)why(703,639)who()![!mul(127,447),)/+where();!where(671,231)+>mul(212,258)mul(44,546)})mul(139,875 &@<mul(585,821)^what()~[&mul(989,728)mul(342,24)]$select()how()mul(364,418)when()when()who()mulfrom()what()*&# $:}why()}mul(474,693)&<when()<how())+{how()mul(226,33$<] mul(660,458)who()mul(161,289)select()?##+mul(470,114)when(){?why()mul(191,922)}from()]mul(788,224)-%:[)mul(943,80),why()#+((;~what()mul(851,893)why()select()]where(),(-)mul(423how()+%mul(899,45)who()!'>(!how()mul(415,381)from()mul(231,70);where()(;;**mul(448,367)@mul(369,854''where()-select()++-select(133,31){select()mul(289,87)^why()!)++where()do()'how();&~what()mul(904,749)[who(),(mul(968,194)from()~how())mul(870,120)!,why()&> what(926,328)&,mul(600,920))select()%mul(115,664)select()[when()+${(mul(610,337)'}><%where()(when()#mul(298,868)mul(867,344)mul(432,958)who()select(5,558)]{+select()[ &mul(973?>$-?>#mul(467,977)how()!@}$&don't()#how()*]mul(352,542)~*~{{mul(134!mul(789,556)>)how()mul(896,384)select()<select()?;^)}mul(605,128)what()+&mul(330,426),[who()when(),+;>mul(888,194)when()+mul(479,997)'-(@ 'mul(191,723)]{!how();:mul(778,490)[%mul(528,355)@what();:what()*where()where()do()~(select())$&when()what()mul(46,146)!#'}*what()who()^>~mul(684#&:]%mul(403,254) mul(577,671)~/'@;where())mul(529&why()<don't()mul(48,344)when()mul(712,163)@%?mul(915,922)mul(549,657)what()mul(329,939)+?who()^when()<&%mul(284,476)]who()from()how()what(){mul(222,43)$mul(847,620')+from(622,485)& what()@do()mul(910,869)$when()<[why()#}?)&mul(929,569:%>,~;mul(788,67)-]mul(207,403)'who(),^$mul(30,554)from())*)~>?mul'/$+%select()mul(488,914)*select()%mul(367#when();?/do()mul(172,584){when(),^mul(539,461)select()how()how()why())@?mul(723,745)mul(459,942)mul(736,786)mul(205,846){]mul(504,389)how()where(249,201)do() ^/;mul(77,56){mul(280,433))mul(371,584):from()+ /select())#;mul(789,626)~]why()>>(>^%select()mul(425,865)&}!when()[<(:mul(147,913)select();*>-!@:^[mul(276,667);select()mul(772,384)> how(936,446)$who()why()/}?%mul(175,418)~mul<where() mul(385,391)(mul(34,685)$from()what()*>:mul(955,486)*-when()$when();how()[>mul(751,36)mul(292,939))(mul(106%mul(922,786)what()<when()how()[mul(311 ]mul(509,319):-)&from(),mul(368,393)](/-mul(669,638)*why()who()(@/%+)*mul(624,613)*@select()how(821,586)]how()<where()mul(755,460{who()$'/^<%where()>;mul(182,524)when()?^+ where();;when()%mul(493,610)*$(don't()what()why()mul(154,36):how()from(287,143),mul(798,764)>>'?why()}?mul(528,806)-mul(320,851),%where()>'?where()@mul(54,119)who(311,101)!}~}@~mul(937,923,how()from()*where()*where()~ when()do()how()^(~ :@mul(658!?mul(217,910)]-$]who()mul(83,725) why()mul(320,495)who(745,748)]how()&(mul(617<$^mul(227,708)$where()]$why()] {do();;>~who()-}#+ mul(704,444)^mul(537,623)[?>]mul(930'mul(950,788):mul(762,538)why()+why()mul(320,188)%}<select()who()<#[mul(409,827)'mul(593,494)}+<#!'from()%#(mul(176,781),[()when(704,705)<#do()mul(867,289);when()@mul(988,363)when()#!,,%select()%%$mul(328,657);mul(267,245)what(),mul(512,563)%%mul(714,108)mul(915,59)how()+from()/mulwhy(276,817)$when();@$<why()< mul(603,610))who()where(2,827)from()what()mul(818,99)*who()+select()mul(862,430)}#<>) #mul(753,588)what(48,169),mul(951,140):mul(227,728)(@:{who()&,why()from(476,624)what()mul(880,404){?[where()*who()/*+when()mul(142,308)?mul(169,329)\r\n"
                + //
                ",why(),<(&(select()mul(741,733)^@@select() from()'mul(548,224)>mul(2,71)?(>who()select()[{,do()@/~who()^?^&mul(725,404)where()how(){^:<select()[mul(297,724)^$:)select()mul(947,838);when()<#~mul(790,28)]?;what(){when()@who()mul(835,540)where(232,111)~*what()mul(972,469)mul(138,483)?who()};~?,mul(341,749)-what()/@where()mul(612,570)*who()what();[-&who()select()mul(515,488),select(614,834)#why()where()don't()~)'$:?how()from()$mul(34,300):#)#:){mul(23,509)(}^&>who(433,615) ]'#mul(562,995)'when()$from()$don't()how()&^#~>mul'when()^,({mul(389,582):~[;who()~<:;mul(471,527)#)mul(508,33)mul(830,991)?(~#mul<@'mul(633,390)$~-[mul(814,262)/mul(22,229)*when()mul(953,625)what()mul(130,679why()]mul(379,547)%?how()who()~/from()mul(714,836((select()who(763,469)when())mul(91,536)&>!mul(652,911)-*$['>/mul(69,842)who():#&$mul(716,899)how()^?&+;,why()mul(982,781)#what()(from()who()/when()%mul(817,868)mul(970,432)^'select()!mul}when()?why()&,?when():mul(831,166)}+-]<[+(/@mul(962,71)why();}mul(154,77)who()-[^@-^$^mul(694,15))-~who():where()mul(528,162)who()how()mul(142,754)why()>mul(655,759)? mul(80,911how(22,960)-::who(769,904)how()!&when()-@mul(635,891) ~how()-<<$mul(870,17)-)>#when()#where():mul(572,986)~!+*when()*<(mul(505,484)why()[*$,',]$~mul(148,423)^/@'from()~(mul(447,149)mul(398,503)>?}+-how(981,143)mul(849,927)mul(414,758)<&**,(#mul(785,945)what()who(),&++]?mul(825,196)$*%}mul(821,830)when();]%who()do()*'#%}$'mul(84/*why()?mul(772,994)!select()*;where()*[[>-mul(726,28);)#why()<:[)mul(605,458)@: ;?*]mul(348,185)select()!'when()}where()mul(589,220)mul(794,413)-mul(304,645)$where()mul(868,644)!mul(721,731)#!{//}[mul(607,787):)[why()select() ]from()['don't()<who())mul(330,519)^$$-%mul(688,27)how()!from()mul(613,901)&>what()&/>select()mul(109,675);]mul(215,90)%]don't()?when(806,426)(where()*&from()mul(510,614)from()!where(){]when()@,mul(556,832)how()mul(311,911),when()!what()why(642,349)<what()&]mul(186,829)how()from()select()mul(282,970)select()< what()who(){mul(564,450)select()why()[>'(<>mul(717,126)(mul(258,73)where()>)how()mul(279,948))&&mul(261,830)what()mul(49,267),<- ]mul(321,66)@when()who()mul(433,995)how():<> what()mul(527,662)*who()mul(421,478)when()mul(691,138)mul(955,262))select()( who()mul(68,370)% >,mul(193,632)why()'[do()mul(524,700)!&! {}/mul(218,55)@what()#who()who()select()!what()select()}mul(565,514){?where()when(){)--+where()mul(109,545)*^<]why()where():^<;mul(105,999)<({-where()&what()]^<mul(987,236)#mul(687,816)@where()mul(938,279)how()mul(691,145)&%how()when(),-what()'+[do()%: (mul(41,544)(:!*mul(570,635);>'>what()?%mul(9,757)mul(813,966);mul(883,668)mul(365,202)&how()$>what()mul(294,171){+{mul(339,99):~$#[-how()}how()mul(889,554){why()*&(&what() #@mul(894,93),^/?mul(336,810);mul(577,787)+^+<}!&mul(869,136)[%{:mul(305,559)'<%*?%^>mul(485,13) ^'?@#what()}$mul(400,334)}^@when()+-&^mul(383,562)! -do()when() mul(299,80)what()]what()?%]mul(138,839)?&mul(227,499))![@who()select()select()'mul(676,445)'~$-$#-*mul(729,898)select()mul(63,361)from()?(+{#mul(250,283)]*&>why()~:select() mul(853,961)don't()what()?+[/}~]mul(681,763)$select()don't()<]{$mul(257,601)+-<select()mul(63,48)where()%[[;,-]*mul(348from()mul(132,829)^]# ]/(#!/usr/bin/perl!&mul(955,599)\r\n"
                + //
                "[)when()]&~}?mul(349,100)where()}mul(639,832)%,#when()do()~from()(?;#why() -mul(291,635) #select()select()select()'mul(68,328))why()%,what()**-mul(958?:;}*!'&^do()![ who()when(433,806):when()mul(561,433)^?[,(select()>'+mul;};*mul(476,757)mul(433,885)how()+'}why()? ^[,mul(753,773!/>[what()#] mul(842,227)[/when()(<when()what(476,533)(mul(22,82>-!- />*do()what()+,what()mul(781,485)(?*((!!*why();mul(38,48)!;where()mul(357,808);;mul(288,574)mul(808,10)mul(494who()-+^&how()]mul(951,296)%$when(235,909):what()mul(610,313){*[mul(149,511)!#?;]:@mul(827,66)~'(when()how()(($from()mul(916,777)-@where()do()[*;!where(451,647)mul(647,320[(;mul(7,633)&+]%mul(473,278)mul(319,778)!^(what()-why()how()~!]mul(726,467)mul(831,806)how();[//<mul(775,347)$}+mul(726,551)~)~ @(+@^$mul(597,921)@${+what()where()<!who()+mul(455,34)[how(){($}@?>?mul(448,270))-~(^mul(511,532)<}^where()mul(760,666)mul(92,145) mul(42,637)mul(5,53))*<:who(136,784)]mul(106,78)><^mul(786,227){<{mul(887,922)from()^what()?(;@where()where()mul(751,988)?,select()who()!;mul(993,608)(^select()[*]/ ;!mul(688,318)&what()where()+~mul(844,978)&/ mul(518,709)do()%'@mul(970[*from(560,231)select()&#!what()$('mul(870,779)}mul(152,548)]what()^%*&why(),how()mul(695,828)$where(203,743)}who()-,%)how()?mul(140,429)mul(220,21)):??when()$what()when() [mul(197,575)&^+^,select()@mul(877,158)/[]who(487,567)$mul(20,722)~*({why()mul(871,95)when()who()!/~mul(620,803<( ?+who()(how()mul(653,206){select()mul(407,149)]when()^&%:what())mul(18,668)mul(619,122)what()!who()'[}when()'+mul(210,989)&how()+-+where(299,182)where()@@do()what()&!why()why();$;(mul(227,605)*where()when()#>from()select():mul(544,743)^?who()how()::};[}mul(356,416){^:why()<@where(36,26)^mul(249,285)who()mul(390,652)$^#@mul(574,50>~what()mul(589,220)mul(232,55)/?~:when():,!mul(307,846)what()$from()}%!from()who()-mul,,from()~, why()]}{don't()-# {)/mul(369,469)?mul(19,907)mul(164,476)- mul!mul(282,691)^^>!]select()?mul(338,811)why():select(566,260) %mul(923,366) > <from()@:}who()do():from()mul(942,26)what()who()[;/how()>mul/]<>@^$-~mul(413,313)}]#from()where()mul(648,753)}who()how():]select()(mul(260,249)] ]what()]/mul(234,679)]select() ^where()>mul(877,30) why(433,917)+*:from()when()mul(710,206)who()?what()mul(784,5)mul(576,49)-who()mul(162,508) $mul(374,31)where(){where()--#mul(147,279)mul(473,743)!where()^/how()mul(44,151)##]!:<what()[+[mul(569,667),- select()##{>mul(569,170)'when()%]do()*who(729,820)% '*mul(777,62)>what()]mul(950,61)*)when(),mul/[{!@,where()select()::mul(710,254)who()mul(763,761)+#mul(937,352)',who()when()^what()what()mul(251,776)when()what(666,132)*[##]mul(92,996)%+)when()don't(){<<(; !when()-mul(191,83)mul(460,881)[when()?%how()}do()& ?-]mul(556,927)mul(959,193)]??~>select();mul(527,510)?{{;%from(221,893)#mul(249,945)#+>mul(544,237)[/'{how() /mul(267,851)&how(),{(}mul(832'{!),!/}mul(307,557))%why()({}mul(26[{/>(mul(843,50)mul(64,418)mul(3,598)+?&]how()~?select()^%mul(872,409)]mul(488,750)[?mul(291,456)what(494,723)from()~mul(214,180)+{mul(826,373)mul(352,25)$+/%?who()mul(621,463)}@'where():who()mul(510,88]how()-+*'@-do()mul(555,787)%^?mul(101,143)[how()what()&where()mul(652,242)$mul(132,913!%from(),'!from(){^do()#%+why()@where()?]?mul(182,828)>*$#*select()mul(41,911)!who()!#-($?mul(427,652)>@#!;~?,mul(401,829)!?#;mul(419,508))who()mul(639,931)/:when(363,502)from(),<?why(),:mul(439,850)@(- ]]where()(*mul(436,463)-:<&&$*why()mul(978,442)]how()@mul(774,966)\r\n"
                + //
                "!<<;who(){'!where(443,792)do()~select() >@<mul(991,617)mul(651,334)mul(606,204)#*~mul(923,691)/#</ <~%what(577,606)where(610,735)mul(612,299)^what()why(287,238);]mul(202,157):&select()what()mul(249,499)~what()mul(551,475){why()-mul(984,743)+:*[mul(663,9)what()%,who()mul(194,110)<mul(491when()@* when()!who()()do()[from()why()from()&mul(479,245)select()*~^'#mul(79',;don't()->/$mul(871,243)%from(84,689)<+:^<when(692,432)select(73,821)mul(388,877)@(%;where()[who()mul(378,483)'-how()+mul(576,182)>[}mul(553,439)*mul(456,902)])what()+:+who(424,382)(mul(652,206)'mul(806,447)}from()+}:--&mul(122,447){~<when()%@}mul(631,200);from()who()why()~/}]what()>mul(282,263){select()where()~~^! from()mul(293,299),how()*#where()+mul(191,296)~select()mul(507,539)!$'why()*)who()>(}mul(943,705)!?mul(607,665)+/&'why(749,819)[%when()#mul(999,373)from(61,311))[:<mul(128,496):why()<}]mul(300,594)*{@how()::who()<mul(705,533):-when(){<@/&&mul(839,490)@[//!how()<mul(720,40)!how()who()@' mul(923,591)(-mul(219,581) $where(),from();!mul$mul(948,585)?who()select(){:when()$]do()>mul(738,871)]what()}how()when() mul(652,488)/$;^ mul(185,880)select();~?/!~/]mul(36;-why()where())from());don't()*+%+)why()where()why()mul(226,434)<&}]#mul(243,420) how() ?)mul(788,699)what()mul(139,65)where();how()select(){mul(775,736)mul(638,276)why()}%from()?#how()$mul(557,233)^mul(788,214)?)where()/'!<[%mul(126,843)+mul(724,72);']mul(763,451)]! ~mul(45,65)@:?how()^&when();mul(967,412)][*don't():);&>mul(554,494)['{!mul(940,910){mul(884,988when():+~,mul(694,443)when()from()&from()#(:how())mul(137,554),{(don't(),+who()>%:{!where()mulselect():%]who()~where()}'mul(282,932))%}how()mul(912,430)mul(422,275)from();))#}mul(291,719)'mul(228,905):where(),mul(297,951))%<mul(351,763)?who()}>/?%what()~/mul(55,551)where(){@mul(602,509)mul<+/from()mul(892,745)(how():select()don't()[};)#mul(710,309)*;!~{}+mul(502,180)when()/mul(748,42)%mul(967,554)%from()*{,^mul(905,988)who() &$<$(mul(832,628)>)'why(405,28)^:mul }mul(684,138)?@*-what()mul(999,175)what():!why()??!#mul(820,632)why()what()][mul(88,163^%select()what(511,414)how()< > mul(556,919)<,from()-~%from(){',mul(551,185)mul(119,633)where())%;<[mul(948,271)mul(768,473)$<&mul(455,58)${+mul(10,588)where():who()what()-where(){where()mul(278,417)who()&;from()/{~why()mul(579,932):)^$; when()^%mul(718,759)from()(@{#*mul(589,406) )@who()<})<mul(129,646)who()what()how()({-(from()^<mul(396,125)' mul(124,605)^mul ) [who()&from()-*do()why(){from()>why()mul(709,199)!/}where()(mul(870,426)&)&@]mul(943,771)what()why(380,470)mul(77,114):]($(mul(255,648))?don't()' mul(223,167)how()[}'from()>)%(/mul(916,377)[}when()mul(203,800)}~where()mul(637$what(314,616)%%+mul(908,5)+mul(654,351)#>mul(277,129)from()&what()mul(385,379)$select()where()+[when()how(68,615)don't()#>'mul(631,708)(+$+;?mul(975,488);from()~<mul(709,628))where()who(),mul(993,979)how()from()@&*mul(200,512)!~mul(513,307)^{mul(54,431)% mul(760,466)when()%}when())'&*^>mul(288,539);(select():;$mul(971,734)><}]!<%how()mul(930,91)mul(495,350)##,$&mul(547,584))#who()(?/mul(651,987),where(),]when()~do()}where()~!#,/why()$-mul(647,831)>when()*^mul(970,350):>!<@:#&#'mul(733,982)!mul(711,84)!when()what()what()~*when()what()-[mul(155,424)]@#!what()>why(734,93)%+^mul(835,960)<(;mul(224,397)mul(460,961)\r\n"
                + //
                "how()mul(569,29)$]^&what(){#'#mul(257,927)mul(262,57)%''(:select()>-+mul(682,237)>&mul(288,390)]>who()mul(993,513);mul(344,101)-!who()who()~who(463,303)do()[,what();)}/select()mul(745,407)?mul(994,769)mul(64,386)where()^mul(649,12)]?#/?,)?when()mul(622,952)'when()why()@mul(748,291):)'%mul(732,541){#]{(mul(56,362)@? how()<) [[{mul(989,553)select()^&when()@>do(){'from()]'/mul(49,38)who()mul(152,282)!mul,mul(417,40);+when()[{mul(315,700)~don't(),mul(202,130)^:mul(149,735))(%mul(488/$){?~:mul(642,551)<where()+:where(526,295)+why()mul(919,260)~<&&$;}? +do()mul(179,593);~(+!!]mul(861,829){mul(631from()(where()who() select()}^ mul(96,350)*]*why()select()where()mul(388,816)*?$from()-who()+where()+mul(324,383)'~~)who(629,306)mul(367,490)/#}'&*why())mul(724~/}what()~from(220,961)what()?#mul(699,273)(%!+mul(740,544))how() who(479,976)who()!?;select()~mul(642,910)~<?select()when()(}from())mul(506,68)from()(~when()what()!)]]^mul(226,343))why()mul(926,201)why()why()?(<how();-mul(830,828)*mul~mul(659,943)select()?from()@?how()mul(951,729)#(@>*?[:mul(562,108),{(+^where(87,180)({,mul(628,628))*from()from()!where()-do()*]mul?from()& /:}where()mul(849,196) ~?from()} when()mul(18,166)*:mul(557,897)!when()where():^how()what()mul(58,489)when()select(); why()]from()#mul(903,900)%from(977,17)#mul(832,848)@select(){from()select()mul(753,825)where()select()mul(994,559)who()how())mul(852,720),--select(818,708)&from(984,800)mul(934,678)!*from()what(622,800)&%)?mul(716,485)mul(80,923)#~%@?[why()mul(448,41)^mul(172,28)}/+;^mul(125,977){]:*>when()~mul(700,828)$ -mul(951,132)select()#($])[who(554,685)<select()mul(120,480)-mul(792,225)#mul(743,130)where()~~select();select()don't()mul(399,684)>how()select()&,mul(972,89)*){^mul(620,244){'don't()[#:,+why()where()mul(438,463);do()~'+mul(476,537)when()select()%<^ mul(526,777)#/'<:;where()mul(389,733)-#!what()>,![mul(348,560)when()*]who():&~&select()mul(428,730)<select()don't()(when()what()from()how()mul(774,586)who()'-%{'mul(369,890)#:[mul(849,311)@ #!!/when()do()$,where()mul(782,442)why()@where()where()$ {^]mul(826,976)$mul(259,470)<who()^ /*,mul(552,567)/'why()who()}select()how()mul(931,428)<mul(671,613)%];+(;don't()]]'%<&>how()++mul(174,765)who(685,116))when(),how()}+mul(446,58)<+{ -[+;mul(465,776)>#select()}mul(620,447)do()?from()mul(926,182)mul(130,767))?select()*select()&$mul(216,440);]}how()why()when()^$mul(681,682) mul(296,323)}/*mul(103,994)[]-mul(792,944) #when()why()#mul(862,401)%}when()}when()^from()mul(447,682);mul(656,332)!mul(54,102) (~,>mul(490,652)^#/what(), why()(}<don't();*:%[[mul(456,598)[mul(992,351)/mul(800,186)/why()who()why(30,101)^%^$mul(569,489))]*@mul(595,426)? ^what()';mul(86,228)<who()how()who())-(>!mul(667,245)'^when()[]mul(656,820)who()mul(497,382)&why()who()/[^mul(581,424){>*-select()mul(861,328)'who()^(who()don't()why()%from())mul(520,710)$mul(441,649)(when()$:')where()%~mul(509,296)what()'%)what()what()mul(461,977)@^+({why()!mul(135,815)?)&'@!how()}]from()mul(88,233)~#(!mul(257,503)+<({;-*(how()mul(430,944)%+&<how()select()+~mul(504,103)>when()mul(734,245):-&};how()select()(%mul(137,800)<+% mul(881,726);:*>how()mul(389,679)-  >^,!{when()mul(737,727)(~-/do():who()where()[{[when()>]mul(600,553)from()select()^select()),$mul(504,926);'-])";
    }
}

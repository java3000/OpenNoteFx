package ru.java3000.opennotefx.services;

//todo add enable boolean
//todo add image name from resource
//todo use textbloks
public enum ServiceType {
    YANDEX("https://disk.yandex.ru/", "Стоимость: 10 ГБ бесплатно, 100 ГБ за 99 рублей в месяц или 990 рублей в год.\n" +
            "Приложения: Windows, macOS, Linux, iOS, Android.\n" +
            "Поддержка русского языка: есть."),
    MAIL("https://cloud.mail.ru/", "Стоимость: 8 ГБ бесплатно, 64 ГБ за 75 рублей в месяц.\n" +
            "Приложения: Windows, macOS, iOS, Android.\n" +
            "Поддержка русского языка: есть."),
    DROPBOX("https://www.dropbox.com/", "Стоимость: до 2 ГБ бесплатно, 2 ТБ за 11,99 доллара в месяц или 119,88 доллара в год.\n" +
            "Приложения: Windows, macOS, Linux, iOS, Android.\n" +
            "Поддержка русского языка: есть."),
    GOOGLE("https://www.google.com/intl/ru_ALL/drive/", "Стоимость: 15 ГБ бесплатно, 100 ГБ за 139 рублей в месяц или 1 390 рублей в год.\n" +
            "Приложения: Windows, macOS, iOS, Android.\n" +
            "Поддержка русского языка: есть."),
    MICROSOFT("https://onedrive.live.com/about/ru-RU/", "Стоимость: 5 ГБ бесплатно, 1 ТБ за 269 или 339 рублей в месяц при оформлении персональной или семейной подписки на Office 365, соответственно.\n" +
            "Приложения: Windows, macOS, iOS, Android, Windows Phone, Xbox.\n" +
            "Поддержка русского языка: есть."),
    MEGA("https://mega.nz/", "Стоимость: 50 ГБ бесплатно, 400 ГБ за 4,99 евро в месяц.\n" +
            "Приложения: Windows, macOS, Linux, iOS, Android, Windows Phone.\n" +
            "Поддержка русского языка: есть."),
    ICLOUD("https://www.icloud.com/", "Стоимость: 5 ГБ бесплатно, 50 ГБ за 59 рублей в месяц.\n" +
            "Приложения: Windows.\n" +
            "Поддержка русского языка: есть."),
    BOX("https://www.box.com/en-gb/home", "Стоимость: 10 ГБ бесплатно, 100 ГБ за 9 евро в месяц.\n" +
            "Приложения: Windows, macOS, iOS, Android.\n" +
            "Поддержка русского языка: есть."),
    IDRIVE("https://www.idrive.com/", "Стоимость: 5 ГБ бесплатно, 2 ТБ за 52,12 доллара в первый год, 69,5 доллара — со второго.\n" +
            "Приложения: Windows, macOS, Linux, iOS, Android, Windows Phone.\n" +
            "Поддержка русского языка: нет."),
    PCLOUD("https://www.pcloud.com/", "Стоимость: 10 ГБ бесплатно, 500 ГБ за 3,99 евро в месяц, 47,88 евро в год или 175 евро за пожизненный доступ, если заплатите сразу.\n" +
            "Приложения: Windows, macOS, Linux, iOS, Android.\n" +
            "Поддержка русского языка: есть."),
    AMAZON("https://www.amazon.com/photos/storage", "Free Space: 5GB\n" +
            "Country of Origin: United States\n" +
            "Since: 2011"),
    SYNK("https://www.sync.com/", "Free Space: 5GB\n" +
            "Country of Origin: Canada\n" +
            "Since: 2011"),
    ALIBABA("https://www.alibabacloud.com/ru/product/object-storage-service#pricing", "Free Space: 5GB\n" +
            "Country of Origin: China\n" +
            "Since: 2009"),
    MEDIAFIRE("https://www.mediafire.com/", "Free Space: 10GB\n" +
            "Country of Origin: United States\n" +
            "Since: 2006"),
    DEGOO("https://degoo.com/", "Free Space: 100GB\n" +
            "Country of Origin: Sweden\n" +
            "Since: 2009"),
    ICEDRIVE("https://icedrive.net/", "Free Space: 10GB\n" +
            "Country of Origin: United Kingdom\n" +
            "Since: 2018"),
    BLOMP("https://www.blomp.com/", "Free Space: 20GB\n" +
            "Country of Origin: Maryland\n" +
            "Since: 2018"),
    BITRIX("https://www.bitrix24.com/prices/", "Free Space: 5GB\n" +
            "Country of Origin: United States\n" +
            "Since: 2012"),
    ZOHO("https://www.zoho.com/docs/features.html", "Free Space: 5GB\n" +
            "Country of Origin: India\n" +
            "Since: 1996"),
    SYNCPlICITY("https://www.syncplicity.com/en/pricing", "Free Space: 10GB\n" +
            "Country of Origin: United States\n" +
            "Since: 2008"),
    BAIDU("https://pan.baidu.com/buy/center#/svip", "2TB free cloud storage space for life"),
    WEIYUN("https://www.weiyun.com/", "free plan offers 10GB. 6TB of storage and other features displayed on the website for ¥30 per month, which is equivalent to $4"),
    NUTSTORE("https://www.jianguoyun.com/", "With the Free Plan, you received 1GB per month for upload, 3GB per month for download and unlimited traffic under normal usage.\n" +
            "\n"),
    COM115("https://115.com/", "ffering new users of 15GB free storage after signing up that increases by 1TB every year without limit or so they say"),
    TRESORIT("https://tresorit.com/", "10GB Max File Size"),
    SINACLOUD("https://www.sinacloud.com/", ""),
    BINFER("https://www.binfer.com/products/share/", ""),
    BACKBLAZE("https://www.expressvpn.com/go/backblaze", ""),
    NORDLOCKER("https://nordlocker.com/", "Free tier: 3GB" +
            "Storage capacity: 500GB" +
            "Number of devices: Unlimited"),
    CROC("", ""),
    BRANDQUAD("", ""),
    ISPRING("", ""),
    SAMSUNG("", ""),
    XIAOMI("", ""),
    YUNPAN("", ""),
    SHARED4("", ""),
    OZIBOX("", ""),
    INTERNXT("", ""),
    KOOFR("", ""),
    MIMEDIA("", ""),
    JUMPSHARE("", ""),
    MTS("",""),
    T1("https://t1-cloud.ru/service/oblachnoe-khranilishche/",""),
    CLOUDDRIVE("https://www.clouddrive.site/",""),
    STORJ("https://www.storj.io/",""),
    CLOUDME("https://www.cloudme.com/en",""),
    ZADARA("https://www.zadara.com/solutions/data-type/file-storage/",""),
    ORACLE("https://www.oracle.com/ru/cloud/storage/",""),
    HUAWEI("https://cloud.huawei.com/",""),
    SBER("https://sbercloud.ru/ru",""),
    LYVE("https://www.seagate.com/ru/ru/services/cloud/storage/",""),
    TERABOX("https://www.terabox.com/",""),
    GMX("https://www.gmx.com/cloud/",""),
    VKCLOUD("https://mcs.mail.ru/cloud-servers/",""),
    BEECLOUD("https://beecloud.beeline.ru/",""),
    SELECTEL("https://selectel.ru/lab/file-storage/","");

    private String url;
    private String description;

    ServiceType(String url, String description) {
        this.url = url;
        this.description = description;
    }
}

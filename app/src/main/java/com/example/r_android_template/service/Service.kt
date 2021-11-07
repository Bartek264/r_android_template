package com.example.r_android_template.service

object Service {

    private const val estateJsonString = """
        [
            {
              "id": 1,
              "estateNo": "123456/5432",
              "area": 23.1242312312435345,
              "land": "Nordrhein-Westfale",
              "district": "Wertheim"
            },
            {
              "id": 2,
              "estateNo": "953431/6372",
              "area": 12.34857234829347,
              "land": "Nordrhein-Westfale",
              "district": "Wertheim"
            },
            {
              "id": 3,
              "estateNo": "944103/0124",
              "area": 0.0387498243,
              "land": "Bayern",
              "district": "Tauberbischofsheim"
            },
            {
              "id": 4,
              "estateNo": "317432/3125",
              "area": 9.00827498243,
              "land": "Bayern",
              "district": "Grünsfeld"
            },
            {
              "id": 5,
              "estateNo": "576321/5647",
              "area": 1.1,
              "land": "Nordrhein-Westfale",
              "district": "Bad Mergentheim"
            },
            {
              "id": 6,
              "estateNo": "563199/1112",
              "area": 1.001234,
              "land": "Nordrhein-Westfale",
              "district": "Creglingen"
            },
            {
              "id": 7,
              "estateNo": "88332211/2223",
              "area": 231.2311234,
              "land": "Bayern",
              "district": "Niederstetten"
            },
            {
              "id": 8,
              "estateNo": "88332211/2223",
              "area": 231.2311234,
              "land": "Bayern",
              "district": "Niederstetten"
            },
            {
              "id": 9,
              "estateNo": "77663322/3334",
              "area": 71.55555555555555555,
              "land": "Bayern",
              "district": "Dörzbach"
            },
            {
              "id": 10,
              "estateNo": "44332211/8531",
              "area": 19.0,
              "land": "Bayern",
              "district": "Schöntal"
            },
            {
              "id": 11,
              "estateNo": "294712/6431",
              "area": 55.43535232130,
              "land": "Nordrhein-Westfale",
              "district": "Künzelsau"
            },
            {
              "id": 12,
              "estateNo": "096134/7531",
              "area": 25.49433850357,
              "land": "Nordrhein-Westfale",
              "district": "Weißbach"
            },
            {
              "id": 13,
              "estateNo": "120938/0912",
              "area": 28.340570359,
              "land": "Nordrhein-Westfale",
              "district": "Öhringen"
            },
            {
              "id": 14,
              "estateNo": "120938/0912",
              "area": 72.09876543,
              "land": "Bayern",
              "district": "Pfedelbach"
            },
            {
              "id": 15,
              "estateNo": "987651/6319",
              "area": 0.013425345635,
              "land": "Bayern",
              "district": "Braunsbach"
            }
        ]
    """

    //Pobieranie wartości JSON ze stałej prywatnej
    fun getJson() : String{
        return estateJsonString
    }
}
<!DOCTYPE HTML>
<html>
     <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
          <meta name="viewport" content="width=device-width">
          
          <title>${character.name}</title>
          
          <style>
               
          /* misc start */
          *{
               margin:0px;
               padding:0px
          }
          
          body{
               font-family:"Lucida Sans Unicode", "Lucida Grande", sans-serif;
          }
          
          .media1140px{
               background-color:#CE9429;
          }
          
          .media768px{
               background-color:#EDD49A;
          }
          
          .media480px{
               background-color:#EFEF34;
          }
          
          .media300px{
               background-color:#82EAFF;
          }
          
          .media1140px, .media768px, .media480px, .media300px{
               padding:15px;
          }
          
          p{
               margin:0 0 20px 0;
          }
          
          .clearb{
               clear:both;
          }
          /* misc end */
          
          
          
          
          
          
          /* header start */
          #mainHeader{
               background-image: url("forest-bg.png");
               background-repeat: no-repeat;
                    background-size: cover;
               padding:0.5em;
               overflow:auto;
          }
          
          #responsiveLogo{
               width:75%;
          }
          
          #responsiveLogo img{
               max-height: 100%;
               max-width: 100%;
          }
          /* header end */
          
          
          
          
          
          /* navigation start */
          nav{
               float:left;
               width:100%;
          }
          
          nav ul{
               list-style-type:none;
               padding:0;
          }
 
          nav ul li{
          
          }
 
          nav ul li a{
               background-color:green;
               border:thin solid #fff;
               color:#fff;
               display:block;
               height:3em;
               line-height:3em;
               text-align:center;
               text-decoration:none;
               width:100%;
          }
          
          nav ul li a:hover{
               background-color:yellow;
               color:#000;
          }
          /* navigation end */
          
          
          
          
          
          /* middle section start */
          #mainSection{
               background-color: #D9F8F2;
               float: left;
               width: 96%;
          }
          
          #sideBox1{
               background-color: #C9A449;
               width: 96%;
          }
          
          #mainSection, #sideBox1{
               overflow: auto;
               padding:2%;
          }
          /* middle section end */
          
          
          
          /* footer start */
          footer{
               background-color:orange;
               height:50px;
               line-height:50px;
               text-align:center;
               width:100%;
          }
          /* footer end */
          
          
          
          
          
          
          
          /* @media start */
          
          /* we don't need to specify for smartphones, that's our default layout */
          
          /*
          -7 inch tablets
          -This CSS will apply for devices with the minimum width of 480 pixels
          */
          @media only screen and (min-width: 480px) {
               #mainHeader {
                    background-image: url("forest-bg.png");
                    background-repeat: no-repeat;
                    background-size: cover;
               }
               
               nav ul li{
                    float:left;
                    width:25%;
               }
          }
          
          /*
          -10 inch tablets
          -This CSS will apply for devices with the minimum width of 768 pixels
          */
          @media only screen and (min-width: 768px) {
               #mainHeader {
                    background-image: url("forest-bg.png");
               }
               
               #mainSection{
                    float: left;
                    width: 61%;
               }
               
               #sideBox1{
                    float: right;
                    width: 30%;
               }
               
               
          }
          
          /*
          -Desktop computers
          -This CSS will apply for devices with the minimum width of 1140 pixels
          */
          @media only screen and (min-width: 1140px) {
               #mainHeader {
                    background-image: url("forest-bg.png");
               }
               
               #responsiveLogo{
                    float:left;
                    width:30%;
               }
               
               nav{
                    float:left;
                    width:70%;
               }
               
               nav ul{
                    margin:1.5em 0 0 0;
               }
          }
          
          table.paleBlueRows {
            font-family: "Times New Roman", Times, serif;
            border: 1px solid #FFFFFF;
            width: 350px;
            height: 30px;
            text-align: center;
            border-collapse: collapse;
          }
          table.paleBlueRows td, table.paleBlueRows th {
            border: 1px solid #FFFFFF;
            padding: 3px 2px;
          }
          table.paleBlueRows tbody td {
            font-size: 13px;
          }
          table.paleBlueRows tr:nth-child(even) {
            background: #D0E4F5;
          }
          table.paleBlueRows thead {
            background: #0B6FA4;
            border-bottom: 5px solid #FFFFFF;
          }
          table.paleBlueRows thead th {
            font-size: 17px;
            font-weight: bold;
            color: #FFFFFF;
            text-align: center;
            border-left: 2px solid #FFFFFF;
          }
          table.paleBlueRows thead th:first-child {
            border-left: none;
          }

          table.paleBlueRows tfoot {
            font-size: 14px;
            font-weight: bold;
            color: #333333;
            background: #D0E4F5;
            border-top: 3px solid #444444;
          }
          table.paleBlueRows tfoot td {
            font-size: 14px;
          }
          table.test {
            font-family: "Times New Roman", Times, serif;
            border: 1px solid #FFFFFF;
            width: 350px;
            height: 30px;
            text-align: left;
            border-collapse: collapse;
          }
          td.bold{
            font-weight: bold;
          }
               
          </style>
          
     </head>
<body>
 
     <header id='mainHeader'>
     
          <div id='responsiveLogo'>
               <img src='test2.png' />
          </div>
          
     </header>
     
     <section id='mainSection'>
 
          <article>
               <header>
                    <h2>${character.name}</h2>
               </header>
               <table class="paleBlueRows">
                <thead>
                <tr>
                  <th>Fighter</th>
                  <th>Noble</th>
                  <th>Dragonborn</th>
                  <th>Lawful Neutral</th>
                </tr>
              </table>
              <table class="paleBlueRows test">
                <tr>
                  <td class="bold">Armor Class</b></td>
                  <td>17</td>
                  <td class="bold">Initiative</td>
                  <td>-2</td>
                  <td class="bold">Speed</td>
                  <td>-30ft.</td>
                </tr>
                <tr>
                  <td class="bold">Max HP</b></td>
                  <td>25</td>
                  <td class="bold">Current HP</td>
                  <td>-200</td>
                  <td class="bold">Temp HP</td>
                  <td></td>
                </tr>
              </table>
               <table class="paleBlueRows">
                <thead>
                <tr>
                  <th>STR</th>
                  <th>DEX</th>
                  <th>CON</th>
                  <th>INT</th>
                  <th>WIS</th>
                  <th>CHA</th>
                </tr>
                </thead>
                <!-- <tfoot>
                  <tr>
                    <td>foot1</td>
                    <td>foot2</td>
                    <td>foot3</td>
                    <td>foot4</td>
                    <td>foot3</td>
                    <td>foot4</td>
                  </tr>
                </tfoot> -->
                <tbody>
                  <tr>
                    <td>20(+2)</td>
                    <td>1(-5)</td>
                    <td>20(+3)</td>
                    <td>18(+1)</td>
                    <td>12(+0)</td>
                    <td>14(+1)</td>
                  </tr>
                </tbody>
                </table>
              
               <p>
                    info
               </p>
               <p>
                    Info
               </p>
               <p>
                    info
               </p>
               <p>
                    info
               </p>
          </article>
 
     </section>
 
     <div class='clearb'></div>
     
     <footer>
          <nav>
               <ul>
                    <li><a href="#home">Edit</a></li>
                    <li><a href="#home">Notes</a></li>
                    <li><a href="#about">Back</a></li>
               </ul>
          </nav>
     </footer>
 
</body>
</html>
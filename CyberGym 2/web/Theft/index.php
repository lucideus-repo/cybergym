<?php

show_source(__FILE__);

if(isset($_GET['a'])){
    $url = parse_url($_GET['a']);
    if(!$url){
        die('Shoo go away: '.$_GET['a']);
    }
    if(substr($_GET['url'], strlen('http://'), strlen('c3483264cea221ce6fa7366baa358ea6e0aa6f61')) === 'c3483264cea221ce6fa7366baa358ea6e0aa6f61'){
        die('If you are SSRF, i will be there for you!');
    }
    if(
        $url['host'] === 'c3483264cea221ce6fa7366baa358ea6e0aa6f61'
    ){
        $ch = curl_init();
        curl_setopt ($ch, CURLOPT_URL, $_GET['a']);
        curl_exec($ch);
        curl_close($ch);
    }else{
        die('Ahaan, Try Smarter');
    }
}



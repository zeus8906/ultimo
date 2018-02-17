/**
 * 
 */
$(document).ready(function() {

    initCards();
    initOpponent1Cards();
    initOpponent2Cards();
    initStatusBar();
    
    function initStatusBar(){
        $('<h1>This is a status message: Szeretlek!</h1>').appendTo($('#statusBar'));
    }
    
    function initOpponent1Cards() {
        for (var i = 0; i < 10; ++i) {
            var card = $('<div />',{"id":"card_"+i, "class":"card"});
            card.css({
                "top": 7.5*i*45/10-i,
                "left": 100+Math.pow(Math.abs(4.5-i),2)*(-3),
                "transform": "rotate("+((i+4.5)*10)+"deg)",
                "background-image": "url('../images/cards/hat.jpg')"
            });
            $("#opponent1Hand").append(card);
        }
    }

    function initOpponent2Cards() {
        for (var i = 0; i < 10; ++i) {
            var card = $('<div />',{"id":"card_"+i, "class":"card"});
            card.css({
                "top": 7.5*i*45/10-i,
                "left": Math.pow(Math.abs(4.5-i),2)*3,
                "transform": "rotate("+(-1*(i+4.5)*10)+"deg)",
                "background-image": "url('../images/cards/hat.jpg')"
            });
            $("#opponent2Hand").append(card);
        }
    }
    
    function initCards() {
        for (var i = 0; i < 10; ++i) {
            var card = $('<div />',{"id":"card_"+i, "class":"card"});
            card.css({
                "left": 7.5*i*45/10-i,
                "top": Math.pow(Math.abs(4.5-i),2)*3,
                "transform": "rotate("+(-1*(4.5-i)*10)+"deg)"
            });
            card.hover(function(){
               this.animate({
                   'left': '+=2px',
                   'top': '+=2px'
               }); 
            });
            card.click(function(){
               $(this).trigger('play-card', [this]); 
               $(this).remove();
            });
            $("#playerHand").append(card);
        }
        
        for(var i = 0; i < 10; ++i){
            $('#card_'+i).css({
                'background-image' : 'url("../images/cards/z7.jpg")'
            });
        }
        
        $('body').on('play-card', function(event, data){
           var center = $('#tableCenter');
           if(center.find('.playedCard').length<3){
               var card  =$('<div>', {
                  class : "card"
               });
               card.css({
                   'background-image' : $(data).css('background-image')
               });
               card.appendTo(center);
               
           }
        });
    }
});
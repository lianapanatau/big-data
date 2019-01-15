<script type="text/javascript">

$('#form').submit(function (e) {
    e.preventDefault();
    $.ajax({
         url: $('#form').attr('action'),
        data: new FormData($(this)[0]),
        cache: false,
        contentType: false,
        processData: false,
        type: 'POST',
        success: function (data) {
           console.log(data);
               iframe = document.getElementById('frameMisteux');
                console.log(iframe);
                iframe.contentWindow.document.open()
                iframe.contentWindow.document.write(data);
                var results = [["Category", "Similarity"]];
                for (var i = 0; i < data.length; i++) {
                    results.push([data[i].category, data[i].similarity]);
                }

                drawMultSeries(results)
        }
    });

});

	function bs_input_file() {
	$(".input-file").before(
		function() {
			if ( ! $(this).prev().hasClass('input-ghost') ) {
				var element = $("<input type='file' class='input-ghost' style='visibility:hidden; height:0'>");
				element.attr("name",$(this).attr("name"));
				element.change(function(){
					element.next(element).find('input').val((element.val()).split('\\').pop());
				});
				$(this).find("button.btn-choose").click(function(){
					element.click();
				});
				$(this).find("button.btn-reset").click(function(){
					element.val(null);
					$(this).parents(".input-file").find('input').val('');
				});
				$(this).find('input').css("cursor","pointer");
				$(this).find('input').mousedown(function() {
					$(this).parents('.input-file').prev().click();
					return false;
				});
				return element;
			}
		}
	);
}
$(function() {
	bs_input_file();
});

google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawMultSeries);

var dateDefault = [
        ['Category', 'Similarity'],
        ["health", 0],
        ["science", 0],
        ["astronomy", 0],
        ["electronics", 0],
        ["gastronomy", 0],
        ["physics", 0],
        ["biology", 0],
        ["sport", 0],
        ["technology", 0]
      ];
var init = true;
function drawMultSeries(data = dateDefault) {
      var data = google.visualization.arrayToDataTable(data);
      if (init) {
          var options = {
            title: 'Matching for categories',
            chartArea: {width: '70%', height: 800},
            hAxis: {
              title: 'Match',
              minValue: 0
            },
            vAxis: {
              title: 'Category'
            }
          };

          var chart = new google.visualization.BarChart(document.getElementById('chart'));
          chart.draw(data, options);
          init = false;
      } else {
            var chart = new google.visualization.BarChart(document.getElementById('chart'));
            chart.draw(data, options);
      }
    }

</script>

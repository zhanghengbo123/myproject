/**
 * @Author:张常平
 * 地图指令
 */
angular.module('app').directive("mapBaidu",
	function($window){
		return {
			restrict: "A",
			scope: {
				address:'=mapBaidu'
			},
			controller: function($scope, $uibModal, $log){
				$scope.address = {state : '中国', province : '', city : '', town : '', village : '', district : '', street : '', streetNumber : '', longitude : '', latitude : ''};
				$scope.setAddress = function(a,b,c,d,e,f,g,callback){
					$scope.address.longitude = a;
					$scope.address.latitude = b;
					$scope.address.province = c;
					$scope.address.city = d;
					$scope.address.district = e;
					$scope.address.street = f;
					$scope.address.streetNumber = g;
					callback();
				};
				$scope.mo = function(){
					var modalInstance = $uibModal.open({
						animation: true,
						scope: $scope,
						template: '<div id="allmap" style="height: 600px;"></div>',
						controller: function($scope){
							setTimeout(function(){
								//创建一个地图
								var map = new BMap.Map("allmap");
								//鼠标滚轮
								map.enableScrollWheelZoom();
								//启动地图的惯性拖拽
								map.enableInertialDragging();
								//启用连续缩放效果
								map.enableContinuousZoom();

								//比例尺控件
								map.addControl(new BMap.ScaleControl());
								//缩略图控件
								map.addControl(new BMap.OverviewMapControl());
								//地图类型控件
								map.addControl(new BMap.MapTypeControl());
								//定位控件
								map.addControl(new BMap.GeolocationControl());

								//中心点
								var point = new BMap.Point(116.404, 39.915);

								//构建地图
								map.centerAndZoom(point, 15);

								// 定位控件设置
								/*var geolocationControl = new BMap.GeolocationControl();
								 geolocationControl.addEventListener("locationSuccess", function(e){
								 // 定位成功事件
								 var address = '';
								 address += e.addressComponent.province;
								 address += e.addressComponent.city;
								 address += e.addressComponent.district;
								 address += e.addressComponent.street;
								 address += e.addressComponent.streetNumber;
								 });
								 geolocationControl.addEventListener("locationError",function(e){
								 // 定位失败事件
								 alert(e.message);
								 });
								 map.addControl(geolocationControl);*/

								//逆地址解析器
								var geoc = new BMap.Geocoder();
								//添加单击事件
								map.addEventListener("click",function(e){
									var pt = e.point;
									geoc.getLocation(pt, function(rs){
										var addComp = rs.addressComponents;
										$scope.setAddress(pt.lng,pt.lat,addComp.province,addComp.city,addComp.district,addComp.street,addComp.streetNumber,function(){
											modalInstance.close();
										});
									});
								});
								var marker = new BMap.Marker(point);
								map.addOverlay(marker);

								//城市列表控件
								var size = new BMap.Size(10, 20);
								map.addControl(new BMap.CityListControl({
									anchor: BMAP_ANCHOR_TOP_LEFT,
									offset: size,
									// 切换城市之间事件
									// onChangeBefore: function(){
									//    alert('before');
									// },
									// 切换城市之后事件
									// onChangeAfter:function(){
									//   alert('after');
									// }
								}));


							},150);
						},
						size: 'lg'
					});
				}
			},
			link:function(scope,element,attr){
				element.bind("click",function(event){
					$window.baiduMapLoaded = function(){
						scope.mo();
					}
					var e = document.createElement("script");
					e.src = "http://api.map.baidu.com/api?v=2.0&ak=vX1PDVx8CVKPhW3MxhXmBoYleGhlEkBN&callback=baiduMapLoaded()";
					document.body.appendChild(e);
				});
			}
		}
	}
);
/**
 * @Author:张常平
 * 等待指令
 */
angular.module('app').directive('butterbar', ['$rootScope',
	function($rootScope) {
		return {
			link: function(scope, element, attrs) {
				element.addClass('hide');

				$rootScope.$on('$routeChangeStart', function() {
					element.removeClass('hide');
				});

				$rootScope.$on('$routeChangeSuccess', function() {
					element.addClass('hide');
				});
			}
		};
	}]);


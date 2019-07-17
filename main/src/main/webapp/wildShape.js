angular.module("wildApp", ["ngRoute"]);
angular.module("wildApp")
    .controller("beastsCtr", function($scope, $http) {
        $http({
            method: "GET", url: "getAll.do"
        }).then(function(response) {
            $scope.beasts = response.data;
            $scope.uniqueBeastCr = $scope.getUniqueCr();
        });
        $scope.sortType = 'name';
        $scope.sortReverse = false;
        $scope.showExtinct = false;
        $scope.showSwarms = false;
        $scope.showMaxCr = false;
        $scope.showSwimming = true;
        $scope.showFlying = true;
        $scope.searchBeasts = '';
        $scope.beastCr;
        $scope.sortMap = new Map([["name" ,false], ["cr", true], ["size", false], ["hp", true], ["ac", true], ["walkingSpeed", true],
            ["swimmingSpeed", true], ["flyingSpeed", true], ["climbingSpeed", true], ["burrow", true], ["strength", true],
            ["dexterity", true], ["constitution", true], ["intelligence", true], ["wisdom", true], ["charisma", true]]);
        $scope.changeSort = function(sorting) {
            if(sorting == $scope.sortType){
                $scope.sortReverse = !$scope.sortReverse;
                $scope.sortMap.set($scope.sortType, $scope.sortReverse);
            } else{
                $scope.sortType = sorting;
                $scope.sortReverse = $scope.sortMap.get(sorting);
            }
        };
        $scope.getUniqueCr = function () {
            var uniqueCr = new Set();
            $scope.beasts.forEach(function (b){
                uniqueCr.add(b.cr)
            });
            return Array.from(uniqueCr).sort();
        };
        $scope.filterCr = function (entry) {
            return entry != undefined && ($scope.showMaxCr == false || $scope.beastCr >= entry.cr);
        };
        $scope.movementTypes = function (entry) {
            return ($scope.showSwimming ? true : entry.swimmingSpeed == 0) && ($scope.showFlying ? true : entry.flyingSpeed == 0);
        };
        $scope.showExtinctBeasts = function (entry) {
           return entry.extinct == false || entry.extinct == $scope.showExtinct;
        };
        $scope.showSwarmBeasts = function (entry) {
           return entry.swarm == false || entry.swarm == $scope.showSwarms;
        };
        $scope.changeShowExtinct = function () {
           $scope.showExtinct = !$scope.showExtinct;
        };
        $scope.changeShowSwarms = function () {
           $scope.showSwarms = !$scope.showSwarms;
        };
        $scope.selBeast = function(beast) {
            $scope.selected_beast = beast;
            angular.element('#myModal').modal();
        }
        $scope.getBeastSpeed = function (beastWalkingSpeed, beastSwimmingSpeed, beastFlyingSpeed, beastClimbingSpeed, beastBurrow ){
            var speed = "";
            if(beastWalkingSpeed > 0){
                speed += beastWalkingSpeed + " ft,"
            }
            if(beastSwimmingSpeed > 0){
                speed += "swim " + beastSwimmingSpeed + " ft,"
            }
            if(beastFlyingSpeed > 0){
                speed += "fly " + beastFlyingSpeed + " ft,"
            }
            if(beastClimbingSpeed > 0){
                speed += "climb " + beastClimbingSpeed + " ft,"
            }
            if(beastBurrow > 0){
                speed += "burrow " + beastBurrow + " ft,"
            }
            return speed.substring(0, speed.length - 1);
        }
        $scope.getAttrWithMod = function (attribute){
            if(attribute < 10){
                return attribute + " (-" + Math.ceil((10-attribute)/2) + ")";
            }
            return attribute + " (+" + Math.floor((attribute-10)/2) + ")";
        }
        $scope.getBeastInfoHtml = function (){
            if($scope.selected_beast != null){
                var infoPanel = document.createElement("div");

                if($scope.selected_beast.savingThrows != null){
                    var b = document.createElement("b");
                    var node = document.createTextNode("Saving Throws: ");
                    b.appendChild(node);
                    infoPanel.appendChild(b);
                    var t = document.createTextNode($scope.selected_beast.savingThrows);
                    infoPanel.appendChild(t);
                    infoPanel.appendChild(document.createElement("br"));
                }
                if($scope.selected_beast.skills != null){
                    var b = document.createElement("b");
                    var node = document.createTextNode("Skills: ");
                    b.appendChild(node);
                    infoPanel.appendChild(b);
                    var t = document.createTextNode($scope.selected_beast.skills);
                    infoPanel.appendChild(t);
                    infoPanel.appendChild(document.createElement("br"));
                }
                if($scope.selected_beast.damageResistance != null){
                    var b = document.createElement("b");
                    var node = document.createTextNode("Damage Resistance: ");
                    b.appendChild(node);
                    infoPanel.appendChild(b);
                    var t = document.createTextNode($scope.selected_beast.damageResistance);
                    infoPanel.appendChild(t);
                    infoPanel.appendChild(document.createElement("br"));
                }
                if($scope.selected_beast.conditionResistance != null){
                    var b = document.createElement("b");
                    var node = document.createTextNode("Condition Resistance: ");
                    b.appendChild(node);
                    infoPanel.appendChild(b);
                    var t = document.createTextNode($scope.selected_beast.conditionResistance);
                    infoPanel.appendChild(t);
                    infoPanel.appendChild(document.createElement("br"));
                }
                if($scope.selected_beast.damageImmunities != null){
                    var t = document.createElement("b");
                    var node = document.createTextNode("Damage Immunities: ");
                    b.appendChild(node);
                    infoPanel.appendChild(b);
                    var b = document.createTextNode($scope.selected_beast.damageImmunities);
                    infoPanel.appendChild(t);
                    infoPanel.appendChild(document.createElement("br"));
                }
                if($scope.selected_beast.conditionImmunities != null){
                    var b = document.createElement("b");
                    var node = document.createTextNode("Condition Immunities: ");
                    b.appendChild(node);
                    infoPanel.appendChild(b);
                    var t = document.createTextNode($scope.selected_beast.conditionImmunities);
                    infoPanel.appendChild(t);
                    infoPanel.appendChild(document.createElement("br"));
                }
                if($scope.selected_beast.senses != null){
                    var b = document.createElement("b");
                    var node = document.createTextNode("Senses: ");
                    b.appendChild(node);
                    infoPanel.appendChild(b);
                    var t = document.createTextNode($scope.selected_beast.senses);
                    infoPanel.appendChild(t);
                    infoPanel.appendChild(document.createElement("br"));
                }
                if($scope.selected_beast.languages != null){
                    var b = document.createElement("b");
                    var node = document.createTextNode("Languages: ");
                    b.appendChild(node);
                    infoPanel.appendChild(b);
                    var t = document.createTextNode($scope.selected_beast.languages);
                    infoPanel.appendChild(t);
                    infoPanel.appendChild(document.createElement("br"));
                }
                if($scope.selected_beast.cr != null){
                    var b = document.createElement("b");
                    var node = document.createTextNode("Challenge: ");
                    b.appendChild(node);
                    infoPanel.appendChild(b);
                    var t = document.createTextNode($scope.getFraction($scope.selected_beast.cr));
                    infoPanel.appendChild(t);
                    infoPanel.appendChild(document.createElement("br"));
                }

                document.getElementById("beastInfoPanel").firstChild.remove();
                document.getElementById("beastInfoPanel").appendChild(infoPanel);
            }
        }
        $scope.getBeastSpecialAbilitiesHtml = function (){
            if($scope.selected_beast != null){
                var abilityPanel = document.createElement("div");

                for(key in $scope.selected_beast.specialAbilities){
                    var b = document.createElement("b");
                    var node = document.createTextNode(key + ": ");
                    b.appendChild(node);
                    abilityPanel.appendChild(b);
                    var t = document.createTextNode($scope.selected_beast.specialAbilities[key]);
                    abilityPanel.appendChild(t);
                    abilityPanel.appendChild(document.createElement("br"));
                }

                document.getElementById("specialAbilitiesPanel").firstChild.remove();
                document.getElementById("specialAbilitiesPanel").appendChild(abilityPanel);
            }
        }
        $scope.getBeastActionsHtml = function (){
            if($scope.selected_beast != null){
                var actionPanel = document.createElement("div");

                for(key in $scope.selected_beast.actions){
                    var b = document.createElement("b");
                    var node = document.createTextNode(key + ": ");
                    b.appendChild(node);
                    actionPanel.appendChild(b);

                    var attack = $scope.selected_beast.actions[key];
                    var str = "";
                    if(attack.desc != null){
                        str += attack.desc;
                        str += ", ";
                    }
                    if(attack.type != null){
                        str += attack.type;
                        str += ", ";
                    }
                    if(attack.reach != null){
                        str += attack.reach + " reach";
                        str += ", ";
                    }
                    if(attack.target != null){
                        str += attack.target;
                        str += ", ";
                    }
                    if(attack.toHit != null){
                        str += attack.toHit + " to hit";
                        str += ", ";
                    }
                    if(attack.onHit != null){
                        str += "Hit: " + attack.onHit;
                        str += ", ";
                    }

                    var t = document.createTextNode(str.substring(0, str.length - 2));
                    actionPanel.appendChild(t);
                    actionPanel.appendChild(document.createElement("br"));
                }

                document.getElementById("actionsPanel").firstChild.remove();
                document.getElementById("actionsPanel").appendChild(actionPanel);
            }
        }
        $scope.getFraction = function(number){
            var decimal = number % 1;
            if(decimal == 0){
                return number;
            }

            var whole = number - decimal;
            var den = Math.pow(10, decimal.countDecimals());
            var num = decimal * den;
            var g = $scope.gcd(num, den);
            return (whole > 0 ? whole + ' ' : '') + num/g + "/" + den/g;
        }
        Number.prototype.countDecimals = function () {
            if(Math.floor(this.valueOf()) === this.valueOf()) return 0;
            return this.toString().split(".")[1].length || 0;
        }
        $scope.gcd = function(a, b) {
            if (b < 0.0000001){
                return a;
            }
            return $scope.gcd(b, Math.floor(a % b));
        };
    });
angular.module("wildApp")
	.config(function($routeProvider, $locationProvider) {
		$locationProvider.hashPrefix("");
		$routeProvider
			.when("/viewBeasts", {
				templateUrl: "beasts.html",
				controller: "beastsCtr"
			})
			.when("/viewDruidRules", {
				templateUrl: "druidRules.html"
			})
			.otherwise({
				template: "<h3 style=\"font-style: oblique\">Welcome!</h3>"
			});
	});
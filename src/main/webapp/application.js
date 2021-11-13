angular.module('main', [])
    .controller('$product', ['$scope', '$http', ($scope, $http) => {
        $scope.productC = {
            image: '',
            name: '',
            description: '',
            price: ''
        };

        $scope.products = [];

        $scope.getProducts = () => {
            $http({
                method: 'GET',
                url: '/api/products'
            }).then(response => {
                $scope.products = response.data;
            }, error => {

            });
        };

        $scope.create = () => {
            $http({
                method: 'POST',
                url: '/api/products',
                data: $scope.productC
            }).then(response => {
                alert('Producto create exitosamente.');
                $scope.getProducts();
            }, error => {

            });
        };

        $scope.getProducts();
    }]);
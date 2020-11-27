<!DOCTYPE html>
<html lang="en">
<!-- lib_header -->
  @include('Library/lib_Header')

<body class="hold-transition sidebar-mini">
  <!-- header navbar -->
    @include('data/header_navbar')
  <!-- Left Menu -->
    @include('data/left_menu')  
      <!-- Content -->
        @yield('content')
  <!-- Footer -->
    @include('data/footer')
 <!-- lib_footer --> 
@include('Library/lib_Footer')
</body>
</html>

<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateGhesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('ghe', function (Blueprint $table) {
            $table->increments('id');
            $table->string('Soghe');
            $table->integer('Loaighe_id')->unsigned()->index();
            $table->integer('Trangthai');
            $table->integer('rap_id')->unsigned()->index();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('Loaighe_id')->references('id')->on('loaighe');
            $table->foreign('rap_id')->references('id')->on('rap');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('ghe');
    }
}
